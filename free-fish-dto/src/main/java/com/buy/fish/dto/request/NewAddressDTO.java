package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName NewAddressDTO
 * @Description 新用户地址添加时，返回的数据类型
 * @Author zsj
 * @Date 2020/03/05
 */
@Setter
@Getter
public class NewAddressDTO implements Serializable {

    private static final long serialVersionUID = 2661911579263653007L;
    /**
     * 收货者姓名
     */
    private String name;
    /**
     * 手机
     */
    private String mobilePhone;
    /**
     * 区号
     */
    private String areaCode;
    /**
     * 固定电话
     */
    private String landLine;
    /**
     * 省编号
     */
    private Integer provinceId;
    /**
     * 省
     */
    private String province;
    /**
     * 市编号
     */
    private Integer cityId;
    /**
     * 市
     */
    private String city;
    /**
     * 县区编号
     */
    private Integer countyId;
    /**
     * 县区
     */
    private String county;
    /**
     * 具体地址
     */
    private String street;
    /**
     * 默认地址标记
     */
    private Integer defaultAddress;
    /**
     * 当前选中
     */
    private Integer checked;
}
