package com.buy.fish.dao.es;

import com.buy.fish.dto.entity.TbGoodPO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName TbGoodPOElasticsearchMapper
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/16 18:11
 */
public interface TbGoodPOElasticsearchMapper extends ElasticsearchRepository<TbGoodPO,String> {
}
