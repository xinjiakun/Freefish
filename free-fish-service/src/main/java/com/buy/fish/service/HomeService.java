package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.dto.TbPanel;

import java.util.List;

public interface HomeService {
    Result<List<TbPanel>> getHome();
}
