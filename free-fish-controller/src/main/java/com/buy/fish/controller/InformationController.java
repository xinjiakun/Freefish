package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.entity.TbUserPO;
import com.buy.fish.dto.request.LoginUserDTO;
import com.buy.fish.service.InformationService;
import com.buy.fish.service.LoginService;
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
 * @ClassName InformationController
 * @Description TODO
 * @Author zsj
 * @Date 2020/3/2
 */
@Api(value = "个人信息页面")
@RestController
@RequestMapping(value = "/api")
public class InformationController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private InformationService informationService;

    @ApiOperation(value = "修改名称")
    @RequestMapping(value = "/information/name", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> checkLoginUser(Integer id,String userName) {
        return new ResultUtil().setData(informationService.changeInfoName(id,userName));
    }

    @ApiOperation(value = "修改头像")
    @RequestMapping(value = "/information/userHeadImg", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> changeHeadImg(Integer id,String userHeadImg) {
        return new ResultUtil().setData(informationService.changeHeadImg(id,userHeadImg));
    }

    @ApiOperation(value = "修改签名")
    @RequestMapping(value = "/information/information", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> changeInformation(Integer id,String userInformation) {
        return new ResultUtil().setData(informationService.changeInformation(id,userInformation));
    }

    @ApiOperation(value = "修改性别")
    @RequestMapping(value = "/information/gender", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> changeInfoGender(Integer id,Integer userGender) {
        return new ResultUtil().setData(informationService.changeInfoGender(id,userGender));
    }

    @ApiOperation(value = "修改邮箱")
    @RequestMapping(value = "/information/email", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> changeInfoEmail(Integer id) {
        return new ResultUtil().setData(informationService.changeInfoEmail(id));
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/information/changepwd", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> changeInfoPwd(Integer id,String pwd) {
        return new ResultUtil().setData(informationService.changeInfoPwd(id,pwd));
    }
}
