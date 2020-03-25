package com.buy.fish.service;

import com.buy.fish.dao.TbGoodMapper;
import com.buy.fish.dao.TbOrderMapper;
import com.buy.fish.dao.TbUserAddressMapper;
import com.buy.fish.dto.entity.TbGoodPO;
import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.entity.TbUserAddressPO;
import com.buy.fish.dto.response.UserOrderVO;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author zsj
 * @Date 2020/3/09
 */
@Component
public class OrderServiceImpl implements OrderService{
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private TbOrderMapper tbOrderMapper;
    @Resource
    private TbGoodMapper tbGoodMapper;
    @Resource
    private TbUserAddressMapper tbUserAddressMapper;

    private UserOrderVO userOrderVO;

    @Override
    public List<UserOrderVO> getAllUserOrder(Integer userId) {
        List<TbOrderPO> order = new ArrayList<>();
        List<UserOrderVO> userOrderVOS = new ArrayList<UserOrderVO>();

        Integer goodId;
        Integer addressId;
        TbGoodPO tbGoodPO = null;
        TbUserAddressPO tbUserAddressPO = null;
        try{
            logger.info("OrderServiceImpl,数据库查询");
            order = tbOrderMapper.queryALLByUserId(userId);
        }catch (Exception e){
            logger.error("OrderServiceImpl,数据库查询失败",e);
        }
        for(int i=0;i<order.size();i++){
            UserOrderVO userOrderVO = new UserOrderVO();
            if(!order.isEmpty()) {
                goodId = order.get(i).getGoodId();
                addressId = order.get(i).getAddressId();
                try{
                    logger.info("此用户的所有订单，循环查询每个订单的商品和寄送地址信息--第"+ (i+1)+"次查询");
                    tbGoodPO = tbGoodMapper.queryById(goodId);
                    tbUserAddressPO = tbUserAddressMapper.queryById(addressId);
                }catch (Exception e){
                    logger.error("此用户的所有订单，循环查询每个订单的商品和寄送地址信息--第\"+ (i+1)+\"次查询失败",e);
                }
                userOrderVO.setId(order.get(i).getId());
                userOrderVO.setOrderId(order.get(i).getOrderId());
                userOrderVO.setState(order.get(i).getState());
                userOrderVO.setTime(order.get(i).getTime());
                userOrderVO.setGoodId(order.get(i).getGoodId());

                userOrderVO.setTitle(tbGoodPO.getTitle());
                userOrderVO.setAliImage(tbGoodPO.getAliImage());
                userOrderVO.setPrice(tbGoodPO.getPrice());
                userOrderVO.setUserId(tbGoodPO.getUserId());
                userOrderVO.setGoodState(tbGoodPO.getGoodState());

                userOrderVO.setProvince(tbUserAddressPO.getProvince());
                userOrderVO.setCity(tbUserAddressPO.getCity());
                userOrderVO.setCounty(tbUserAddressPO.getCounty());
                userOrderVO.setStreet(tbUserAddressPO.getStreet());
                userOrderVO.setProvince(tbUserAddressPO.getProvince());
                userOrderVO.setName(tbUserAddressPO.getName());
                userOrderVO.setMobilePhone(tbUserAddressPO.getMobilePhone());
                userOrderVOS.add(userOrderVO);
            }

        }
        return userOrderVOS;
    }

    @Override
    public int confirmReceipt(Integer ordreId, Integer goodId) {
        Integer state = 2;
        Integer goodState = 0;
        try{
            tbOrderMapper.updateState(ordreId,state);
            tbGoodMapper.updateGoodState(goodId,goodState);
            logger.info("confirmReceipt确认收货---tbOrderMapper/tbGoodMapper数据库修改成功");
            return 1;
        }catch (Exception e){
            logger.error("confirmReceipt确认收货---tbOrderMapper/tbGoodMapper数据库修改失败",e);
        }
        return 0;
    }

    @Override
    public int requestRefund(Integer ordreId, Integer goodId) {
        Integer state = 0;
        Integer goodState = 2;
        try{
            tbOrderMapper.updateState(ordreId,state);
            tbGoodMapper.updateGoodState(goodId,goodState);
            logger.info("requestRefund申请退款---tbOrderMapper/tbGoodMapper数据库修改成功");
            return 1;
        }catch (Exception e){
            logger.error("requestRefund申请退款---tbOrderMapper/tbGoodMapper数据库修改失败",e);
        }
        return 0;
    }


}
