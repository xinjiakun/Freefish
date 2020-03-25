package com.buy.fish.service;

import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.response.GoodVO;
import com.buy.fish.dto.response.UserOrderVO;

import java.util.List;

public interface OrderService {
    /**
     * 查询用户所有订单
     *
     * @param /
     * @return List<TbOrderPO>
     */
    List<UserOrderVO> getAllUserOrder(Integer userId);

    /**
     * 确认收货
     *
     * @param /
     * @return int
     */
    int confirmReceipt(Integer ordreId,Integer goodId);

    /**
     * 申请退款
     *
     * @param /
     * @return
     */
    int requestRefund(Integer ordreId, Integer goodId);
}
