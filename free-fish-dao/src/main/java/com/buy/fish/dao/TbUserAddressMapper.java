package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbUserAddressPO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbUserAddress)表数据库访问层
 *
 * @author zsj
 * @since 2020-03-02
 */
@Mapper
public interface TbUserAddressMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUserAddressPO queryById(Integer id);

    /**
     * 查询所有此用户的地址
     *
     * @param  userId
     * @return 对象列表
     */
    List<TbUserAddressPO> queryALLByUserId(@Param("userId") int userId);

    /**
     * 新增数据
     *
     * @param tbUserAddressPO 实例对象
     * @return 影响行数
     */
    int userAddressInsert(TbUserAddressPO tbUserAddressPO);

    /**
     * 修改默认地址标记
     *
     * @param  id 和 defaultAddress
     * @return 影响行数
     */
    int updateDefaultAddressById(@Param("id") int id,@Param("defaultAddress") int defaultAddress);

    /**
     * 修改选中地址标记
     *
     * @param  id 和 checked
     * @return 影响行数
     */
    int updateCheckedAddressById(@Param("id") int id,@Param("checked") int checked);

    /**
     * 更新原地址信息
     *
     * @param id tbUserAddressPO 实例对象
     * @return 影响行数
     */
    int updateUserAddressById(@Param("id") int id,@Param("newtbUserAddress") TbUserAddressPO tbUserAddressPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteUserAddressById(Integer id);

}