package com.buy.fish.dto.enumerate;

import com.buy.fish.common.config.converter.BaseEnum;

/**
 * @ClassName OldOrEnum
 * @Description 新旧程度枚举
 * @Author xinjiakun
 * @Date 2020/2/15 18:03
 */
public enum OldOrEnum implements BaseEnum {
    ALL_GOODS(0, "全部"),
    TEN_PERCENT(1, "全新"),
    NINE_PERCENT(2, "9成新"),
    SEVEN_PERCENT(3, "7成新"),
    FIVE_PERCENT(4, "5成及以下");

    private Integer code;
    private String name;

    OldOrEnum(Integer code, String name) {
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
