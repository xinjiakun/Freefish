package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbGoodPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbGood)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-15 16:52:11
 */
@Mapper
public interface TbGoodMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbGoodPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TbGoodPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 列表页条件查询
     *
     * @param lowerPrice highPrice
     * @return 对象列表
     */
    List<TbGoodPO> queryAll(@Param("lowerPrice") Integer lowerPrice,@Param("highPrice") Integer highPrice,
                            @Param("typeOb") Integer typeOb, @Param("oldOr")Integer oldOr,@Param("sort") String sort);

    /**
     * 首页条件查询
     *
     * @param
     * @return 对象列表
     */
    List<TbGoodPO> queryHome(@Param("sort") String sort);

    /**
     * 新增数据
     *
     * @param tbGoodPO 实例对象
     * @return 影响行数
     */
    int insert(TbGoodPO tbGoodPO);

    /**
     * 修改数据
     *
     * @param tbGoodPO 实例对象
     * @return 影响行数
     */
    int update(TbGoodPO tbGoodPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}