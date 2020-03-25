package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName SubmitOrderDTO
 * @Description TODO
 * @Author zsj
 * @Date 2020/03/09
 */
@Setter
@Getter
public class SubmitOrderDTO implements Serializable {

    private static final long serialVersionUID = -6723826353377970213L;

    /**
     * 订单号
     */
    private String orderId;
    /**
     * 商品Id
     */
    private Integer goodId;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 地址Id
     */
    private Integer addressId;
}
