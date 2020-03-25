package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName RegisterUserDTO
 * @Description register注册时，返回的数据类型
 * @Author zsj
 * @Date 2020/2/26
 */

@Getter
@Setter
public class RegisterUserDTO implements Serializable {
    private static final long serialVersionUID = -5801054243531815478L;
    private Integer id;
    /**
     * 登录邮箱
     */
    private String email;

    /**
     * 登录名称
     */
    private String name;

    /**
     * 初始信用值
     */
    private Integer credit;

    /**
     * 登录密码
     */
    private String pwd;
}

