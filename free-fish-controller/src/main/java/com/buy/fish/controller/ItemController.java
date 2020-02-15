package com.buy.fish.controller;

import com.alibaba.fastjson.JSONArray;
import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.request.CommentDTO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.GoodVO;
import com.buy.fish.service.HomeService;
import com.buy.fish.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ItemController
 * @Description 商品详情页
 * @Author xinjiakun
 * @Date 2020/2/15 17:30
 */
@Api(value = "商品详情页")
@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "获取商品详情及评论")
    @RequestMapping(value = "/good", method = RequestMethod.POST)
    @ResponseBody
    public Result<GoodVO> getGood(GoodsDTO goodsDTO) {
        return itemService.getGoodDetails(goodsDTO);
    }

    @ApiOperation(value = "对商品评分")
    @RequestMapping(value = "/score", method = RequestMethod.POST)
    @ResponseBody
    public Result getScore(String score) {
        return itemService.getScore(score);
    }

    @ApiOperation(value = "写评论")
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result getComment(CommentDTO commentDTO) {
        return itemService.getComment(commentDTO);
    }
}
