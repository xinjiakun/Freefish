package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2020-02-15 16:35:18
 */
@Setter
@Getter
public class TbUserPO implements Serializable {
    private static final long serialVersionUID = 399171135283861720L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户名
    */
    private String name;
    /**
    * 用户头像
    */
    private String headimg;
    /**
    * 手机号
    */
    private String number;


}