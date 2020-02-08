package com.buy.fish.dao;

import com.buy.fish.dto.TbPanel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbPanelMapper {

    List<TbPanel> selectByExample();

}
