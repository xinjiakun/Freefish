package com.buy.fish.dto.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TbPanel
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 20:02
 */
@Setter
@Getter
public class TbPanel implements Serializable {
    private Integer id;

    private String name;

    private Integer type;

    private Integer sortOrder;

    private Integer position;

    private Integer limitNum;

    private Integer status;

    private String remark;

    private Date created;

    private Date updated;

}
