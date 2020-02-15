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
     * 评论用户名
     */
    private String name;
    /**
     * 评论用户头像
     */
    private String img;
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
     * 子评论
     */
    private List<CommentVO> commentVOS;
}
