package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbCommentPO;
import com.buy.fish.dto.response.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-15 16:50:27
 */
@Mapper
public interface TbCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCommentPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbCommentPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbCommentPO 实例对象
     * @return 对象列表
     */
    List<TbCommentPO> queryAll(TbCommentPO tbCommentPO);

    /**
     * 查询顶级评论
     *
     * @param goodId 商品ID
     * @return 对象列表
     */
    List<CommentVO> queryByGoodId(String goodId);
    /**
     * 查询子评论
     *
     * @param parentId 父评论ID
     * @return 对象列表
     */
    List<CommentVO> queryByparentId(Integer parentId);
    /**
     * 新增数据
     *
     * @param tbCommentPO 实例对象
     * @return 影响行数
     */
    int insert(TbCommentPO tbCommentPO);

    /**
     * 修改数据
     *
     * @param tbCommentPO 实例对象
     * @return 影响行数
     */
    int update(TbCommentPO tbCommentPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}