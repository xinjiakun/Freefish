package com.buy.fish.dao;

import com.buy.fish.dto.entity.TbPanel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbPanelMapper {

    List<TbPanel> selectByExample();

}
