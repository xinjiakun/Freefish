package com.buy.fish.service;

import com.alibaba.fastjson.JSON;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dao.TbPanelMapper;
import com.buy.fish.dto.TbPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HomeService
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 21:16
 */
@Component
public class HomeServiceImpl implements HomeService{
    private final static Logger logger = LoggerFactory.getLogger(HomeService.class);

    @Autowired
    private TbPanelMapper tbPanelMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    public Result<List<TbPanel>> getHome(){
        List<TbPanel> tbPanels;
        String key = "home";
        ValueOperations<String, List<TbPanel>> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            long start = System.currentTimeMillis();
            tbPanels = operations.get(key);
            long end = System.currentTimeMillis();
            logger.info("home缓存查询成功,花费时间为{}", end - start + "ms");
        } else {
            long start = System.currentTimeMillis();
            tbPanels= tbPanelMapper.selectByExample();
            long end = System.currentTimeMillis();
            logger.info("home数据库查询成功,花费时间为{}", end - start + "ms");
            operations.set(key, tbPanels, 5, TimeUnit.HOURS);
            logger.info("home缓存添加成功");
        }
        return new ResultUtil().setData(tbPanels);
    }
}
