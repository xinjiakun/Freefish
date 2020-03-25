package com.buy.fish.controller;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.common.pojo.ResultUtil;
import com.buy.fish.dto.entity.TbUserAddressPO;
import com.buy.fish.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author zsj
 * @Date 2020/3/2
 */
@Api(value = "收货地址")
@RestController
@RequestMapping(value = "/api")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "全部地址展示")
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<TbUserAddressPO>> getAllUserAddress(Integer userId) {

        return new ResultUtil().setData(addressService.getAllUserAddress(userId));
    }

    @ApiOperation(value = "默认地址标记更改")
    @RequestMapping(value = "/address/default", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> changeDefaultAddress(Integer adrsid,Integer receiveYes) {

        return new ResultUtil().setData(addressService.changeDefaultAddress(adrsid,receiveYes));
    }

    @ApiOperation(value = "新收货地址添加")
    @RequestMapping(value = "/address/newAddress", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> newAddress(String newAddressReceive, Integer userId) {

        return new ResultUtil().setData(addressService.newAddress(newAddressReceive,userId));
    }

    @ApiOperation(value = "旧收货地址信息修改")
    @RequestMapping(value = "/address/changeOldAddress", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> changeOldAddress(String oldAddressReceive, Integer userId, Integer id) {

        return new ResultUtil().setData(addressService.changeOldAddress(oldAddressReceive,userId,id));
    }

    @ApiOperation(value = "原地址删除")
    @RequestMapping(value = "/address/deleteAddress", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> deleteAddress(Integer id) {

        return new ResultUtil().setData(addressService.deleteAddress(id));
    }
}
