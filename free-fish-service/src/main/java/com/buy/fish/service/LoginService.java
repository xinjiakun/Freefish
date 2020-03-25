package com.buy.fish.service;

import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.LoginUserDTO;
import com.buy.fish.dto.response.GoodVO;

import java.util.List;

public interface LoginService {
    /**
     * 查询
     * zsj
     * @param
     * @return
     */
    TbUserPO checkLoginUser(LoginUserDTO loginUserDTO);
}
