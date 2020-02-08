package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.TbPanel;
import com.buy.fish.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 16:18
 */
@Api(value = "首页展示")
@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation(value = "首页获取")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<TbPanel>> getHome() {

        return new ResultUtil().setData(homeService.getHome());
    }
}
