package com.buy.fish.service;

import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.RegisterUserDTO;

public interface RegisterService {

    /**
     * 插入
     * zsj
     * @param
     * @return
     */
    TbUserPO registerNewUser(RegisterUserDTO registerUserDTO);
}
