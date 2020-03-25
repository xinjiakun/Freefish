package com.buy.fish.service;

import com.buy.fish.common.pojo.Md5Util;
import com.buy.fish.dao.TbUserMapper;
import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.LoginUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
public class LoginServiceImpl implements LoginService{
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private TbUserMapper tbUserMapper;

    private Md5Util md5Util;

    @Override
    public TbUserPO checkLoginUser(LoginUserDTO loginUserDTO) {
        TbUserPO tbUserPO1;
        String md5Pwd = md5Util.md5(loginUserDTO.getUserPwd());
        try{
            tbUserPO1 = tbUserMapper.queryByEmail(loginUserDTO.getUserEmail());
            if (loginUserDTO.getUserEmail().equals(tbUserPO1.getEmail()) && md5Pwd.equals(tbUserPO1.getPwd())){
                logger.info("邮箱密码正确");
                return tbUserPO1;
            }else {
                logger.info("用户邮箱或密码错误");
                return null;
            }
        }catch (Exception e){
            logger.info("数据库查询失败");
        }
        return null;
    }
}
