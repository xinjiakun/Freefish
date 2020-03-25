package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (TbUserAddress)实体类
 *
 * @author zsj
 * @since 2020-02-27
 */
@Setter
@Getter
public class TbUserAddressPO implements Serializable {

    private static final long serialVersionUID = 8902633799667290325L;
    /**
     * 主键ID
     */
    private Integer id;
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
     * 外键，用户id   数据库无设计外键
     */
    private  Integer userId;
    /**
     * 手机
     */
    private String mobilePhone;
    /**
     * 固定电话
     */
    private String landLine;
    /**
     * 区号
     */
    private String areaCode;
    /**
     * 默认地址标记
     */
    private  Integer defaultAddress;
    /**
     * 收货者姓名
     */
    private String name;
    /**
     * 当前选中
     */
    private Integer checked;
    /**
     * 省编号
     */
    private Integer provinceId;
    /**
     * 市编号
     */
    private Integer cityId;
    /**
     * 县区编号
     */
    private Integer countyId;
}
