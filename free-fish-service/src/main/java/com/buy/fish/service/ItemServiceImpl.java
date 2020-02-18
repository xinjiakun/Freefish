package com.buy.fish.service;

import com.buy.fish.common.config.converter.EnumConvertFactory;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.dao.TbCommentMapper;
import com.buy.fish.dao.TbGoodMapper;
import com.buy.fish.dto.entity.TbCommentPO;
import com.buy.fish.dto.entity.TbGoodPO;
import com.buy.fish.dto.entity.TbPanel;
import com.buy.fish.dto.enumerate.OldOrEnum;
import com.buy.fish.dto.request.CommentDTO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.CommentVO;
import com.buy.fish.dto.response.GoodVO;
import com.buy.fish.dto.response.ImagesDO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/15 17:43
 */
@Component
public class ItemServiceImpl implements ItemService {

    private final static Logger logger = LoggerFactory.getLogger(HomeService.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private TbGoodMapper tbGoodMapper;
    @Resource
    private TbCommentMapper tbCommentMapper;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public GoodVO getGoodDetails(Integer id) {
        String key = "sku_" + id;
        GoodVO goodVO;
        TbGoodPO tbGoodPO;
        ValueOperations<String, TbGoodPO> operations = redisTemplate.opsForValue();
        //查询rides缓存 未命中则查询mysql
        if (redisTemplate.hasKey(key)) {
            long start = System.currentTimeMillis();
            tbGoodPO = operations.get(key);
            long end = System.currentTimeMillis();
            logger.info("商品详情缓存查询成功,花费时间为{}", end - start + "ms");
        } else {
            long start = System.currentTimeMillis();
            tbGoodPO = tbGoodMapper.queryById(id);
            long end = System.currentTimeMillis();
            logger.info("商品详情数据库查询成功,花费时间为{}", end - start + "ms");
            operations.set(key, tbGoodPO, 5, TimeUnit.MINUTES);
            logger.info("商品详情缓存添加成功");
        }
        // 对象字段映射转化
        goodVO = dozerBeanMapper.map(tbGoodPO, GoodVO.class);
        goodVO.setOldOr(new EnumConvertFactory().getIEnum(OldOrEnum.class, goodVO.getOldOr()).getName());
        //备用图封装转化
        goodVO.setImagesDO(dozerBeanMapper.map(tbGoodPO, ImagesDO.class));
        goodVO.getImagesDO().setAliImages(tbGoodPO.getAliImage());
        //评论添加
        List<CommentVO> commentVOS = getComment(id);
        goodVO.setCommentVOS(commentVOS);
        return goodVO;
    }

    public List<CommentVO> getComment(Integer goodId) {
        String key = "comment_" + goodId;
        List<CommentVO> commentVOS;
        ValueOperations<String, List<CommentVO>> operations = redisTemplate.opsForValue();
        //添加rides缓存 未命中则查询mysql
        if (redisTemplate.hasKey(key)) {
            commentVOS = operations.get(key);
        } else {
            //查找顶级评论
            commentVOS = tbCommentMapper.queryByGoodId(String.valueOf(goodId));
            //添加子评论
            for (CommentVO commentVO : commentVOS) {
                commentVO.setCommentVOS(tbCommentMapper.queryByparentId(commentVO.getId()));
                commentVO.setCommentNum(commentVO.getCommentVOS().size());
            }
        }
        return commentVOS;
    }

    @Override
    public boolean getScore(String score, Integer id) {
        try {
            TbGoodPO tbGoodPO = tbGoodMapper.queryById(id);
            logger.info("评分查询成功{}", tbGoodPO.toString());
            float sum = (tbGoodPO.getScore() * tbGoodPO.getScoreNum()) + Float.valueOf(score);
            Float newScore = sum / (tbGoodPO.getScoreNum() + 1);
            tbGoodPO.setScore(newScore);
            tbGoodPO.setScoreNum(tbGoodPO.getScoreNum() + 1);
            logger.info("商品评分为 {},评分人数为{}", newScore, tbGoodPO.getScoreNum());
            String key = "sku_" + id;
            tbGoodMapper.update(tbGoodPO);
            logger.info("评分更新成功");
            ValueOperations<String, TbGoodPO> operations = redisTemplate.opsForValue();
            if (redisTemplate.hasKey(key)) {
                long start = System.currentTimeMillis();
                operations.set(key, tbGoodPO, 5, TimeUnit.MINUTES);
                long end = System.currentTimeMillis();
                logger.info("商品详情缓存更新成功,花费时间为{}", end - start + "ms");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("评分失败{}", e.getStackTrace());
            return false;
        }
        return true;
    }

    @Override
    public boolean getComment(CommentDTO commentDTO) {
        TbCommentPO tbCommentPO = dozerBeanMapper.map(commentDTO, TbCommentPO.class);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        tbCommentPO.setTime(timestamp);
        logger.info("评论详情为{}", tbCommentPO.toString());
        try {
            tbCommentMapper.insert(tbCommentPO);
        } catch (Exception e) {
            logger.error("商品评论插入失败{}", e.toString());
        }
        return true;
    }
}
