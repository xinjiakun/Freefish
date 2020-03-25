package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.dto.entity.TbUserAddressPO;
import com.buy.fish.dto.request.NewAddressDTO;

import java.util.List;

public interface AddressService {
    /**
     * 查询所有用户地址信息
     * zsj
     * @param
     * @return List<TbUserAddressPO>
     */
    List<TbUserAddressPO> getAllUserAddress(Integer userId);
    /**
     * 更改默认地址
     * zsj
     * @param
     * @return
     */
    int changeDefaultAddress(Integer adrsid,Integer receiveYes);
    /**
     * 新地址添加
     * zsj
     * @param
     * @return
     */
    int newAddress(String newAddressDTO, Integer userId);
    /**
     * 原地址信息更新
     * zsj
     * @param
     * @return
     */
    int changeOldAddress(String newAddressDTO, Integer userId, Integer id);
    /**
     * 原地址删除
     * zsj
     * @param
     * @return
     */
    int deleteAddress(Integer id);
}
