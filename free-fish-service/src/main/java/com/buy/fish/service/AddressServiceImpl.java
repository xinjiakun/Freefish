package com.buy.fish.service;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.buy.fish.dao.TbUserAddressMapper;
import com.buy.fish.dto.entity.TbUserAddressPO;
import com.buy.fish.dto.request.NewAddressDTO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AddressServiceImpl implements AddressService {
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private TbUserAddressMapper tbUserAddressMapper;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;
    @Override
    public List<TbUserAddressPO> getAllUserAddress(Integer userId) {
//        List<TbUserAddressPO> userAddressList = new ArrayList();
        try{
            logger.info("查询用户所有地址，进入try");
//            userAddressList=tbUserAddressMapper.queryALLByUserId(userId);
            logger.info("所有地址信息在一个数组，返回数组"+ tbUserAddressMapper.queryALLByUserId(userId));
            return tbUserAddressMapper.queryALLByUserId(userId);
        }catch (Exception e){
            logger.error("首页数据库查询错误",e);
        }
        return null;
    }

    @Override
    public int changeDefaultAddress(Integer id,Integer receiveYes) {
        Integer defaultAddress;
        try{
            if(receiveYes == 1){//此标记为，你是被选中将要设为默认的地址
                logger.info("你是被选中将要设为默认的地址");
                defaultAddress = 1;
            }else {
                logger.info("这不是被选中要被设为默认的地址");
                defaultAddress = 0;
            }
            return tbUserAddressMapper.updateDefaultAddressById(id,defaultAddress);
        }catch (Exception e){
            logger.error("数据库更新默认地址错误",e);
        }
        return 0;
    }

    @Override
    public int newAddress(String newAddressDTO, Integer userId) {
        TbUserAddressPO tbUserAddressPO1;

        //将json字符串转换为json对象
        JSONObject jsonObject = JSONObject.parseObject(newAddressDTO);
        NewAddressDTO newAddressDTO1 = (NewAddressDTO)JSONObject.toJavaObject(jsonObject,NewAddressDTO.class);

        // 对象字段映射转化
        logger.info("新地址插入：newAddressDTO字段映射前{}", JSON.toJSONString(newAddressDTO1));
        tbUserAddressPO1 = dozerBeanMapper.map(newAddressDTO1,TbUserAddressPO.class);
        logger.info("字段映射后{}", JSON.toJSONString(tbUserAddressPO1));
        tbUserAddressPO1.setUserId(userId);
        try{
            tbUserAddressMapper.userAddressInsert(tbUserAddressPO1);
            return 1;
        }catch (Exception e){
            logger.error("数据库插入失败{}", e);
        }
        return 0;
    }

    @Override
    public int changeOldAddress(String newAddressDTO, Integer userId, Integer id) {
        TbUserAddressPO tbUserAddressPO2;

        //将json字符串转换为json对象
        JSONObject jsonObject = JSONObject.parseObject(newAddressDTO);
        NewAddressDTO newAddressDTO1 = (NewAddressDTO)JSONObject.toJavaObject(jsonObject,NewAddressDTO.class);

        // 对象字段映射转化
        logger.info("旧地址更新：newAddressDTO字段映射前{}", JSON.toJSONString(newAddressDTO1));
        tbUserAddressPO2 = dozerBeanMapper.map(newAddressDTO1,TbUserAddressPO.class);
        logger.info("字段映射后{}", JSON.toJSONString(tbUserAddressPO2));
        tbUserAddressPO2.setUserId(userId);
        try{
            tbUserAddressMapper.updateUserAddressById(id,tbUserAddressPO2);
            logger.info("旧地址更新完成");
            return 1;
        }catch (Exception e){
            logger.error("数据库插入失败{}", e);
        }
        return 0;
    }

    @Override
    public int deleteAddress(Integer id) {
        try{
            tbUserAddressMapper.deleteUserAddressById(id);
            logger.info("地址成功删除");
            return 1;
        }catch (Exception e){
            logger.error("数据库地址删除失败",e);
        }
        return 0;
    }
}
