package com.buy.fish.service;

import com.buy.fish.dao.TbOrderMapper;
import com.buy.fish.dao.TbUserAddressMapper;
import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.request.SubmitOrderDTO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName CheckoutServiceImpl
 * @Description TODO
 * @Author zsj
 * @Date 2020/3/8
 */
@Service
public class CheckoutServiceImpl implements CheckoutService{
    private final static Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    @Resource
    private TbOrderMapper tbOrderMapper;
    @Resource
    private TbUserAddressMapper tbUserAddressMapper;
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Override
    public int changeCheckedAddress(Integer adrsid, Integer checked) {
        try{
            logger.info("changeCheckedAddress修改选中地址标记");
            return tbUserAddressMapper.updateCheckedAddressById(adrsid,checked);
        }catch (Exception e){
            logger.error("hangeCheckedAddress修改选中地址标记--失败",e);
        }
        return 0;
    }

    @Override
    public int submitOrder(SubmitOrderDTO submitOrderDTO) {
        //字段映射
        TbOrderPO tbOrderPO = dozerBeanMapper.map(submitOrderDTO, TbOrderPO.class);
        //添加时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        tbOrderPO.setTime(timestamp);
        tbOrderPO.setState(1);

        try {
            //数据库插入订单
            logger.info("数据库插入订单");
            tbOrderMapper.userOrderInsert(tbOrderPO);
            return 1;
        } catch (Exception e) {
            logger.error("数据库插入订单失败{}", e);
            return 0;
        }
    }
}
