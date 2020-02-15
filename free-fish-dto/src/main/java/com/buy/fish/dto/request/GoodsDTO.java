package com.buy.fish.dto.request;

import com.buy.fish.dto.enumerate.OldOrEnum;
import com.buy.fish.dto.enumerate.SortEnum;
import com.buy.fish.dto.enumerate.SubjectEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName GoodsDTO
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/15 18:13
 */
@Setter
@Getter
public class GoodsDTO implements Serializable {
    private static final long serialVersionUID = -6776847121393619336L;
    /**
     * 新旧程度
     */
    private OldOrEnum oldOrEnum;
    /**
     * 排序类型
     */
    private SortEnum sortEnum;
    /**
     * 商品类别
     */
    private SubjectEnum subjectEnum;
    /**
     * 最低价
     */
    private String lowerPrice;
    /**
     * 最高价
     */
    private String highPrice;
}
