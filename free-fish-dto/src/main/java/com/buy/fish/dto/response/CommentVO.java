package com.buy.fish.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName commentVO
 * @Description 评论
 * @Author xinjiakun
 * @Date 2020/2/15 19:47
 */
@Setter
@Getter
public class CommentVO implements Serializable {
    private static final long serialVersionUID = -6770894286509697047L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品id
     */
    private Integer goodId;
    /**
     * 评论用户名
     */
    private String name;
    /**
     * 评论用户头像
     */
    private String headImg;
    /**
     * 评论from用户id
     */
    private Integer fromUserId;
    /**
     * 评论to用户名
     */
    private String toName;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 评论时间
     */
    private Date time;
    /**
     * 父评论id
     */
    private Integer parentId;
    /**
     * 子评论数量
     */
    private Integer commentNum;
    /**
     * 输入框默认关闭
     */
    private final boolean inputShow = false;
    /**
     * 子评论默认关闭
     */
    private final boolean senShow = false;
    /**
     * 子评论
     */
    private List<CommentVO> commentVOS;
}
