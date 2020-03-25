package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * (TbOrderPO)实体类
 *
 * @author makejava
 * @since 2020-03-09
 */
@Setter
@Getter
@Document(indexName = "freefish" , type = "tbOrderPO")
public class TbOrderPO implements Serializable {
    private static final long serialVersionUID = 1643489233483235942L;

    /**
     * 主键
     */
    @Id
    private Integer id;
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
    /**
     * 状态标记[1-已付款未收货2-已完成确认收货；0-订单取消]
     */
    private Integer state;
    /**
     * 订单生成时间
     */
    private Date time;
}
