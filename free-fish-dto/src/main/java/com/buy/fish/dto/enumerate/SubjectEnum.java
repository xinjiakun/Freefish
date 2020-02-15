package com.buy.fish.dto.enumerate;

import com.buy.fish.common.config.converter.BaseEnum;

/**
 * @ClassName SubjectEnum
 * @Description 商品类型枚举
 * @Author xinjiakun
 * @Date 2020/2/15 18:03
 */
public enum SubjectEnum implements BaseEnum {
    ALL_GOODS(0, "全部"),
    DIGITAL_ELECTRONICS(1, "数码电子"),
    CLOTHES(2, "服饰球鞋"),
    BEAUTY_MAKEUP(3, "美妆"),
    BOOK(4, "图书"),
    SUPPLIES(5, "生活用品"),
    SPORTS_EQUIPMENT(6, "运动装备"),
    OTHERS(7, "其他");

    private Integer code;
    private String name;

    SubjectEnum(Integer code, String name) {
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
