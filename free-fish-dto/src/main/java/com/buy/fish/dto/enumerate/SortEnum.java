package com.buy.fish.dto.enumerate;

import com.buy.fish.common.config.converter.BaseEnum;

/**
 * @ClassName SortEnum
 * @Description 排序枚举
 * @Author xinjiakun
 * @Date 2020/2/15 18:01
 */
public enum  SortEnum implements BaseEnum {
    SORT(0, "综合排序"),
    SHELF_TIME(1, "上架时间"),
    END_PRICE_TO_HIGH(2, "价格低到高"),
    HIGH_PRICE_TO_END(3, "价格高到低");

    private Integer code;
    private String name;

    SortEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
