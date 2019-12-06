package com.buy.fish.controller;

import com.alibaba.fastjson.JSONObject;
import com.buy.fish.result.BaseRusult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinjiakun
 * @title: testController
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 18:22
 */
@Api(value = "/test",tags = {"测试"})
@RestController
@RequestMapping("/test")
public class testController {

    @PostMapping(value = "/test")
    @ApiOperation(value = "测试")
    public BaseRusult test(String index){
        index=index.replaceAll("\\\\","");
        JSONObject jsonObject = JSONObject.parseObject(index);

        System.out.println(jsonObject.getString("address"));
        return new BaseRusult(true,200,"测试");
    }
}
