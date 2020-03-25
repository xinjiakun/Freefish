package com.buy.fish.controller;

import com.alibaba.fastjson.JSON;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author zsj
 * @Date 2020/03/07
 */
@Api(value = "商品发布页面")
@RestController
@RequestMapping(value = "api")
public class UploadController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "商品发布")
    @RequestMapping(value = "/upload/uploadNewGoods", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> registerNewUser(Integer userId, String goodtitle , String goodsubtitle , Integer goodprice, Integer goodtype, Integer goodold, Integer goodpostage, MultipartFile aliImg1,MultipartFile[] aliImg2) {
        logger.info("UploadController");

        return new ResultUtil().setData(uploadService.uploadNewGood(userId, goodtitle , goodsubtitle , goodprice, goodtype, goodold,goodpostage, aliImg1,aliImg2));

    }
}
