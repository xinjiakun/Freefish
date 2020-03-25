package com.buy.fish.dto.response;

import com.buy.fish.dto.entity.TbGoodPO;
import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.entity.TbUserAddressPO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserOrderVO
 * @Description 订单细则
 * @Author zsj
 * @Date 2020/3/9
 */
@Setter
@Getter
public class UserOrderVO implements Serializable {
    private static final long serialVersionUID = 2697543750545342126L;
    /**
     * 订单主键ID
     */
    private Integer id;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 状态标记[1-已付款未收货2-已完成确认收货；0-订单取消]
     */
    private Integer state;
    /**
     * 订单生成时间
     */
    private Date time;
    /**
     * 商品Id
     */
    private Integer goodId;

    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品主图
     */
    private String aliImage;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 上传商品用户id
     */
    private Integer userId;
    /**
     * 商品状态
     */
    private Integer goodState;
    /**
     * 商品邮费
     */
    private Integer postage;

    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 县区
     */
    private String county;
    /**
     * 具体地址
     */
    private String street;
    /**
     * 收货者姓名
     */
    private String name;
    /**
     * 手机
     */
    private String mobilePhone;
}
