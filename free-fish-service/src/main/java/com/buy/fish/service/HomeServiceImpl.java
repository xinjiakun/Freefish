package com.buy.fish.service;

import com.alibaba.fastjson.JSONObject;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dao.TbGoodMapper;
import com.buy.fish.dao.TbPanelMapper;
import com.buy.fish.dao.es.TbGoodPOElasticsearchMapper;
import com.buy.fish.dto.entity.TbGoodPO;
import com.buy.fish.dto.entity.TbPanel;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.GoodVO;
import org.dozer.DozerBeanMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HomeService
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 21:16
 */
@Service
public class HomeServiceImpl implements HomeService {
    private final static Logger logger = LoggerFactory.getLogger(HomeService.class);

    @Resource
    private TbPanelMapper tbPanelMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private TbGoodMapper tbGoodMapper;
    @Autowired
    private TbGoodPOElasticsearchMapper tbGoodPOElasticsearchMapper;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<List<GoodVO>> getHome() {
        List<TbPanel> tbPanels;

//        return tbPanels;
        List<List<GoodVO>> homeLists = new ArrayList();
        homeLists.add(getConverter(tbGoodMapper.queryHome("score")));
        homeLists.add(getConverter(tbGoodMapper.queryHome("create_time")));
        homeLists.add(getConverter(tbGoodMapper.queryHome("typeObj")));

        return homeLists;
    }

    public List<GoodVO> getConverter(List<TbGoodPO> goodPOList){
        List<GoodVO> goodVOList = new ArrayList<>();
        for (TbGoodPO tbGoodPO : goodPOList) {
            goodVOList.add(dozerBeanMapper.map(tbGoodPO,GoodVO.class));
        }
        return goodVOList;
    }

    @Override
    public List<GoodVO> getNowSelect(String select) {
        return null;
    }

    @Override
    public List<TbGoodPO> getSelect(String select) {
        // 定义高亮字段
        HighlightBuilder.Field titleField = new HighlightBuilder.Field("title").preTags("<span>").postTags("</span>");
        HighlightBuilder.Field contentField = new HighlightBuilder.Field("subTitle").preTags("<span>").postTags("</span>");

        // 构建查询内容
        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(select);
        // 查询匹配的字段
        queryBuilder.field("title").field("subTitle");

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder)
                .withHighlightFields(titleField, contentField).build();
        long count = elasticsearchTemplate.count(searchQuery, TbGoodPO.class);
        System.out.println("系统查询个数：--》" + count);
        if (count == 0) {
            return new ArrayList<>();
        }
        //需要的话可以实现分页效果，注意，页面是从 0 开始
        searchQuery.setPageable(new PageRequest(0, (int) count));

        AggregatedPage<TbGoodPO> queryForPage = elasticsearchTemplate.queryForPage(searchQuery, TbGoodPO.class,
                new SearchResultMapper() {

                    @Override
                    public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz,
                                                            Pageable pageable) {

                        List<TbGoodPO> list = new ArrayList<TbGoodPO>();
                        for (SearchHit searchHit : response.getHits()) {
                            if (response.getHits().getHits().length <= 0) {
                                return null;
                            }
                            TbGoodPO tbGoodPO = JSONObject.parseObject(searchHit.getSourceAsString(), TbGoodPO.class);
                            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                            //匹配到的title字段里面的信息
                            HighlightField titleHighlight = highlightFields.get("title");
                            if (titleHighlight != null) {
                                Text[] fragments = titleHighlight.fragments();
                                String fragmentString = fragments[0].string();
                                tbGoodPO.setTitle(fragmentString);
                            }
                            //匹配到的subTitle字段里面的信息
                            HighlightField contentHighlight = highlightFields.get("subTitle");
                            if (contentHighlight != null) {
                                Text[] fragments = contentHighlight.fragments();
                                String fragmentString = fragments[0].string();
                                tbGoodPO.setSubTitle(fragmentString);
                            }
                            list.add(tbGoodPO);

                        }
                        if (list.size() > 0) {
                            return new AggregatedPageImpl<>((List<T>) list);
                        }
                        return null;
                    }
                });
        List<TbGoodPO> list = queryForPage.getContent();

        return list;
//        return null;
    }

    @Override
    public List<GoodVO> getGoods(GoodsDTO goodsDTO) {
        List<GoodVO> goodVOList = new ArrayList<>();
        Integer lowerPrice = null;
        Integer highPrice = null;
        try {
            lowerPrice = Integer.valueOf(goodsDTO.getLowerPrice());
        } catch (NumberFormatException e) {
            logger.error("最低价格解析错误{}", e.getMessage());
        }
        try {
            highPrice = Integer.valueOf(goodsDTO.getHighPrice());
        } catch (NumberFormatException e) {
            logger.error("最高价格解析错误{}", e.getMessage());
        }

        Integer typeOb = goodsDTO.getSubjectEnum().getCode().equals(0) ? null : goodsDTO.getSubjectEnum().getCode();
        Integer oldOr = goodsDTO.getOldOrEnum().getCode().equals(0) ? null : goodsDTO.getOldOrEnum().getCode();
        String sort = sortParam(goodsDTO.getSortEnum().getCode());
        logger.info("sql入参为lowerPrice:{},highPrice:{},typeOb:{},oldOr;{},sort:{}",
                lowerPrice, highPrice, typeOb, oldOr, sort);
        try {
            List<TbGoodPO> tbGoodPOS = tbGoodMapper.queryAll(lowerPrice, highPrice, typeOb, oldOr, sort);
            logger.info("查询数据为{}", tbGoodPOS.toString());
            for (TbGoodPO tbGoodPO : tbGoodPOS) {
                goodVOList.add(dozerBeanMapper.map(tbGoodPO, GoodVO.class));
            }
            logger.info("数据库查询成功");
        } catch (Exception e) {
            logger.error("数据库查询失败{}", e.toString());

        }
        return goodVOList;
    }

    public String sortParam(Integer sortEnum) {
        if (sortEnum.equals(0)) {
            return "score";
        } else if (sortEnum.equals(1)) {
            return "create_time";
        } else if (sortEnum.equals(2)) {
            return "endToHigh";
        } else {
            return "price";
        }
    }
}
