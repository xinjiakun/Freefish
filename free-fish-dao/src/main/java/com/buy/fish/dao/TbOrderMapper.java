package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbOrderPO;
import com.buy.fish.dto.entity.TbUserAddressPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbOrderMapper)表数据库访问层
 *
 * @author zsj
 * @since 2020-03-09
 */
@Mapper
public interface TbOrderMapper {
    /**
     * 查询所有此用户的订单
     *
     * @param  userId
     * @return 对象列表
     */
    List<TbOrderPO> queryALLByUserId(@Param("userId") int userId);

    /**
     * 新增数据
     *
     * @param tbOrderPO 实例对象
     * @return 影响行数
     */
    int userOrderInsert(TbOrderPO tbOrderPO);

    /**
     * 确认收货,修改订单状态
     *
     * @param
     * @return 影响行数
     */
    int updateState(@Param("orderId") Integer orderId,@Param("state")int state);
}
