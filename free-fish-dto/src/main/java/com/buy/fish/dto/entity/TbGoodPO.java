package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbGood)实体类
 *
 * @author makejava
 * @since 2020-02-15 16:47:53
 */
@Setter
@Getter
public class TbGoodPO implements Serializable {
    private static final long serialVersionUID = 640092019396004382L;
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
    * 类别
    */
    private String typeOb;
    /**
    * 新旧程度
    */
    private Integer oldOr;
    /**
    * 分数
    */
    private float score;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 上传商品用户id
    */
    private Integer userId;


}