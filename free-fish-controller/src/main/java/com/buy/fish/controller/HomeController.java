package com.buy.fish.controller;

import com.alibaba.fastjson.JSONArray;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.GoodVO;
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
@RequestMapping(value = "/api")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @ApiOperation(value = "首页获取")
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    @ResponseBody
    public Result<JSONArray> getHome(String name) {
        String array = "[{'value':'" + name + "'},{'value':'" + name + name + "'}]";
        JSONArray jsonArray = JSONArray.parseArray(array);
//        return new ResultUtil().setData(jsonArray);
        return new ResultUtil().setData(null);
//        return new ResultUtil().setData(homeService.getHome());
    }

    @ApiOperation(value = "搜索")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<GoodVO>> getSelect(String select) {
        return homeService.getSelect(select);
    }

    @ApiOperation(value = "全部商品及条件查询")
    @RequestMapping(value = "/allGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<GoodVO>> getAllGoodsSelect(GoodsDTO goodsDTO) {
        return homeService.getGoods(goodsDTO);
    }


}
