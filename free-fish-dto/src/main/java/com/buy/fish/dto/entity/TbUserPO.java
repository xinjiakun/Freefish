package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author zsj
 * @since 2020-02-20 16:35:18
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
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer gender; //1-男、2-女
    /**
     * 信用额
     */
    private Integer credit;
    /**
     * 简介
     */
    private String information;
    /**
     * 密码
     */
    private String pwd;
}