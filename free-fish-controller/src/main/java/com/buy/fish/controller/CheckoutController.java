package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.request.SubmitOrderDTO;
import com.buy.fish.dto.response.GoodVO;
import com.buy.fish.service.CheckoutService;
import com.buy.fish.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CheckoutController
 * @Description 订单生成支付页
 * @Author zsj
 * @Date 2020/3/8
 */
@Api(value = "订单生成支付页")
@RestController
@RequestMapping(value = "/api")
public class CheckoutController {
    private final static Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired
    private CheckoutService checkoutService;

    @ApiOperation(value = "地址选中")
    @RequestMapping(value = "/checkout/checked", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> getCheckedAddress(Integer adrsid, Integer checked) {

        return new ResultUtil().setData(checkoutService.changeCheckedAddress(adrsid,checked));
    }

    @ApiOperation(value = "订单提交")
    @RequestMapping(value = "/checkout/submit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> submitOrder(SubmitOrderDTO submitOrderDTO) {
        logger.info("/checkout/submit-submitOrder(SubmitOrderDTO submitOrderDTO)");
        return new ResultUtil().setData(checkoutService.submitOrder(submitOrderDTO));
    }
}
