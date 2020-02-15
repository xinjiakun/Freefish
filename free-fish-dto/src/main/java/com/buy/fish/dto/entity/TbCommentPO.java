package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbComment)实体类
 *
 * @author makejava
 * @since 2020-02-15 16:44:02
 */
@Setter
@Getter
public class TbCommentPO implements Serializable {
    private static final long serialVersionUID = 445551685381681712L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 商品id
    */
    private Integer goodId;
    /**
    * 评论用户id
    */
    private Integer fromUserId;
    /**
    * 评论to用户id
    */
    private Integer toUserId;
    /**
    * 评论内容
    */
    private String comment;
    /**
    * 评论时间
    */
    private Date time;
    /**
    * 顶级父评论id(无父评论填0)
    */
    private Integer parentId;


}