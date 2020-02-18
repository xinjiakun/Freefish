package com.buy.fish.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName Images
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/17 18:35
 */
@Getter
@Setter
public class ImagesDO implements Serializable {
    private static final long serialVersionUID = 6122702479680686752L;
    /**
     * 主图
     */
    private String aliImages;
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
}
