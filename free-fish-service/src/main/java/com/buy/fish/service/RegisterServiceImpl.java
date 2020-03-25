package com.buy.fish.service;

import com.alibaba.fastjson.JSON;
import com.buy.fish.common.pojo.Md5Util;
import com.buy.fish.dao.TbUserMapper;
import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.RegisterUserDTO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
public class RegisterServiceImpl implements RegisterService{
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private TbUserMapper tbUserMapper;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    private Md5Util md5Util;


    @Override
    public TbUserPO registerNewUser(RegisterUserDTO registerUserDTO) {
        TbUserPO tbUserPO1;
        int ID;
        String md5Pwd = md5Util.md5(registerUserDTO.getPwd());
        registerUserDTO.setPwd(md5Pwd);
        try{
            ID = tbUserMapper.registerInsert(registerUserDTO);
            logger.info("注册插入数据库成功");

            // 对象字段映射转化
            logger.info("字段映射前{}", JSON.toJSONString(registerUserDTO));
            tbUserPO1 = dozerBeanMapper.map(registerUserDTO, TbUserPO.class);

            logger.info("字段映射后{}", JSON.toJSONString(tbUserPO1));
            return tbUserPO1;
        }catch (Exception e) {
            logger.error("数据库插入失败{}", e);
            return null;
        }

    }

}
