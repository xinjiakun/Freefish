package com.buy.fish.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xinjiakun
 * @title: BaseRusult
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "基本result")
public class BaseRusult implements Serializable {
    @ApiModelProperty(value = "返回状态码 200:成功")
    private Integer code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "扩展对象")
    private Object object;

    public BaseRusult(boolean success, Integer code, String message) {
        this.code=code;
        this.message=message;
        this.success=success;
    }
}
