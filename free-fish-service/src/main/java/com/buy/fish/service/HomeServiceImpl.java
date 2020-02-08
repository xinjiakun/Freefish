package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dao.TbPanelMapper;
import com.buy.fish.dto.TbPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName HomeService
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 21:16
 */
@Component
public class HomeServiceImpl implements HomeService{
    private final static Logger LOGGER = LoggerFactory.getLogger(HomeService.class);

    @Autowired
    private TbPanelMapper tbPanelMapper;

    public Result<List<TbPanel>> getHome(){
        List<TbPanel> tbPanels= tbPanelMapper.selectByExample();
        return new ResultUtil().setData(tbPanels);
    }
}
