package com.buy.fish.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 17:04
 */
@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;
}
