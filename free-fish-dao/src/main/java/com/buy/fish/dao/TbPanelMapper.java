package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbPanel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TbPanelMapper {

//    @Select("select * from tb_panel")
    List<TbPanel> selectByExample();

}
