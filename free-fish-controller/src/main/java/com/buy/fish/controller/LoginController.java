package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.request.LoginUserDTO;
import com.buy.fish.dto.response.GoodVO;
import com.buy.fish.service.HomeService;
import com.buy.fish.service.LoginService;
import com.buy.fish.service.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static sun.misc.Version.print;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author zsj
 * @Date 2020/2/20 20:43
 */
@Api(value = "登录页面")
@RestController
@RequestMapping(value = "/api")
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录验证")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<TbUserPO> checkLoginUser(LoginUserDTO loginUserDTO) {
        return new ResultUtil().setData(loginService.checkLoginUser(loginUserDTO));
    }

}
