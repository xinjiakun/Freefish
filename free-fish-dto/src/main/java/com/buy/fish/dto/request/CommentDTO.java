package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CommentDTO
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/15 18:18
 */
@Setter
@Getter
public class CommentDTO implements Serializable {
    private static final long serialVersionUID = -4283624671803519135L;
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
     * 顶级父评论id(无父评论填0)
     */
    private Integer parentId;
}
