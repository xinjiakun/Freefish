package com.buy.fish.service;

import com.buy.fish.dto.request.SubmitOrderDTO;

public interface CheckoutService {
    /**
     * 更改选中标示
     * zsj
     * @param
     * @return
     */
    int changeCheckedAddress(Integer adrsid,Integer checked);

    /**
     * 提价订单
     * zsj
     * @param
     * @return
     */
    int submitOrder(SubmitOrderDTO submitOrderDTO);
}
