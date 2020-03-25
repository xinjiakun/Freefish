package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName LoginUserDTO
 * @Description login登录时，返回的数据类型
 * @Author zsj
 * @Date 2020/2/26
 */
@Setter
@Getter
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = -7658577703681284039L;
    /**
     * 登录邮箱
     */
    private String userEmail;

    /**
     * 登录密码
     */
    private String userPwd;
}
