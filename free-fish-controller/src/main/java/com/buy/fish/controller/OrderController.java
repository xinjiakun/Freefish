package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.response.UserOrderVO;
import com.buy.fish.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description 用户订单页
 * @Author zsj
 * @Date 2020/3/9
 */
@Api(value = "订单生成支付页")
@RestController
@RequestMapping(value = "/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "查询用户订单")
    @RequestMapping(value = "/order/all", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<UserOrderVO>> getAllUserOrder(Integer userId) {

        return new ResultUtil().setData(orderService.getAllUserOrder(userId));
    }

    @ApiOperation(value = "确认收货")
    @RequestMapping(value = "/order/confirmReceipt", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> confirmReceipt(Integer orderId,Integer goodId) {

        return new ResultUtil().setData(orderService.confirmReceipt(orderId,goodId));
    }

    @ApiOperation(value = "申请退款")
    @RequestMapping(value = "/order/requestRefund", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> requestRefund(Integer orderId,Integer goodId) {

        return new ResultUtil().setData(orderService.requestRefund(orderId,goodId));
    }
}
