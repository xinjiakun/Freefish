package com.buy.fish.service;

import com.buy.fish.common.pojo.Md5Util;
import com.buy.fish.common.pojo.SendEmail;
import com.buy.fish.dao.TbUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
public class InformationServiceImpl implements InformationService{
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private TbUserMapper tbUserMapper;

    private SendEmail sendEmail;
    private Md5Util md5Util;

    @Override
    public String changeInfoName(Integer id ,String name) {
        try{
            logger.info("将要开始更新数据");
            tbUserMapper.updateName(id, name);
            logger.info("数据库修改成功-名字");
            return name;
        }catch (Exception e){
            logger.error("数据库修改失败{}", e);
            return null;
        }

    }

    @Override
    public String changeHeadImg(Integer id, String userHeadImg) {
        try{
            logger.info("将要开始更新数据");
            tbUserMapper.updateHeadImg(id, userHeadImg);
            logger.info("数据库修改成功-头像");
            return userHeadImg;
        }catch (Exception e){
            logger.error("数据库修改失败{}", e);
            return null;
        }
    }

    @Override
    public String changeInformation(Integer id, String information) {
        try{
            logger.info("将要开始更新数据");
            tbUserMapper.updateInformation(id, information);
            logger.info("数据库修改成功-签名");
            return information;
        }catch (Exception e){
            logger.error("数据库修改失败{}", e);
            return null;
        }
    }

    @Override
    public Integer changeInfoGender(Integer id, Integer gender) {
        try{
            logger.info("将要开始更新数据");
            tbUserMapper.updateGender(id, gender);
            logger.info("数据库修改成功-性别");
            return 1;
        }catch (Exception e){
            logger.error("数据库修改失败{}", e);
            return 0;
        }
    }

    @Override
    public Integer changeInfoEmail(Integer id) {
        try{
            sendEmail.changeEmail();logger.info("ahhahahahhahaha");
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public Integer changeInfoPwd(Integer id, String pwd) {
        String md5Pwd = md5Util.md5(pwd);
        try{
            logger.info("将要开始更新数据");
            tbUserMapper.updatePwd(id, md5Pwd);
            logger.info("数据库修改成功-密码");
            return 1;
        }catch (Exception e){
            logger.error("数据库修改失败{}", e);
            return 0;
        }
    }
}
