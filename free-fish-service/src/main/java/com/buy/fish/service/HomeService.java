package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.dto.entity.TbGoodPO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.request.Page;
import com.buy.fish.dto.response.GoodVO;

import java.util.List;

public interface HomeService {
    /**
     * 获取首页 热门商品 最新上架 数码电子
     *
     * @param /
     * @return List<GoodVO>
     */
    List<List<GoodVO>> getHome();


    /**
     * 搜索
     *
     * @param select
     * @return List<GoodVO>
     */
    List<GoodVO> getSelect(String select);


    /**
     * 全部商品及条件查询(价格、新旧、类别)及排序
     *
     * @param goodsDTO
     * @return List<GoodVO>
     */
    List<GoodVO> getGoods(GoodsDTO goodsDTO);
}
