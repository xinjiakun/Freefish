package com.buy.fish.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName GoodVO
 * @Description 商品详情
 * @Author xinjiakun
 * @Date 2020/2/15 19:47
 */
@Setter
@Getter
public class GoodVO implements Serializable {
    private static final long serialVersionUID = -6425884606707446862L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品编号
     */
    private Integer skuId;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品介绍
     */
    private String subTitle;
    /**
     * 商品主图
     */
    private String aliImage;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 新旧程度
     */
    private String oldOr;
    /**
     * 备用图
     */
    private ImagesDO imagesDO;
    /**
     * 评论```````````
     */
    private List<CommentVO> commentVOS;
    /**
     * 商品邮费
     */
    private Integer postage;
}
