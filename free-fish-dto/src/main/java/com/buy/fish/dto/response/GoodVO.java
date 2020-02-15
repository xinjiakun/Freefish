package com.buy.fish.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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
     * 备用图1
     */
    private String aliImages1;
    /**
     * 备用图2
     */
    private String aliImages2;
    /**
     * 备用图3
     */
    private String aliImages3;
    /**
     * 备用图4
     */
    private String aliImages4;
    /**
     * 新旧程度
     */
    private Integer oldOr;
}
