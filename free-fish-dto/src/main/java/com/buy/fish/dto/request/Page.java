package com.buy.fish.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Page
 * @Description 分页
 * @Author xinjiakun
 * @Date 2020/2/18 22:34
 */
@Getter
@Setter
public class Page {
    /**
     * 页数
     */
    private Integer pageNum;
    /**
     *页面大小
     */
    private Integer pageSize;
}
