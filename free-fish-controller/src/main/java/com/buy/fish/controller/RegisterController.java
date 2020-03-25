package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.RegisterUserDTO;
import com.buy.fish.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RegisterLoginController
 * @Description TODO
 * @Author zsj
 * @Date 2020/2/26
 */
@Api(value = "注册页面")
@RestController
@RequestMapping(value = "/api")
public class RegisterController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "注册操作")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result<TbUserPO> registerNewUser(RegisterUserDTO registerUserDTO) {
        logger.info("registercontroller");
        return new ResultUtil().setData(registerService.registerNewUser(registerUserDTO));
    }
}
