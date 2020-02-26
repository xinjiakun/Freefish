package com.buy.fish.service;

import com.buy.fish.dao.TbUserMapper;
import com.buy.fish.dto.entity.TbUserPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class LoginServiceImpl implements LoginService{
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);
    private TbUserMapper tbUserMapper;
    @Override
    public TbUserPO getEmail(String email) {
        TbUserPO tbUserPO;
        try{
            tbUserMapper.queryByEmail(email);
        }catch (Exception e){
            logger.error("首页数据库查询错误",e);
        }

        return null;
    }
}
