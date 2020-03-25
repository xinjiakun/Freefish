package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.buy.fish.dto.request.RegisterUserDTO;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-15 16:52:44
 */
@Mapper
public interface TbUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUserPO queryById(Integer id);

    /**
     * 通过Email查询单条数据
     *
     * @param email 邮箱
     * @return 实例对象
     */
    TbUserPO queryByEmail(String email);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUserPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUserPO 实例对象
     * @return 对象列表
     */
    List<TbUserPO> queryAll(TbUserPO tbUserPO);

    /**
     * 新增数据-注册
     *
     * @param registerUserDTO 实例对象
     * @return 返回数据库自增主键，唯一性
     */
    int registerInsert(RegisterUserDTO registerUserDTO);

    /**
     * 修改数据
     *
     * @param tbUserPO 实例对象
     * @return 影响行数
     */
    int update(TbUserPO tbUserPO);

    /**
     * 修改名字
     *
     * @param
     * @return 影响行数
     */
    int updateName(@Param("id") int id,@Param("name")String name);

    /**
     * 修改头像
     *
     * @param
     * @return 影响行数
     */
    int updateHeadImg(@Param("id") int id,@Param("Headimg")String img);

    /**
     * 修改签名
     *
     * @param
     * @return 影响行数
     */
    int updateInformation(@Param("id") int id,@Param("information")String information);

    /**
     * 修改性别
     *
     * @param
     * @return 影响行数
     */
    int updateGender(@Param("id") int id,@Param("gender")int gender);

    /**
     * 修改密码
     *
     * @param
     * @return 影响行数
     */
    int updatePwd(@Param("id") int id,@Param("pwd")String pwd);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}