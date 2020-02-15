package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.dto.request.CommentDTO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.GoodVO;

import java.util.List;

public interface ItemService {
    /**
     * 获取商品详情及评论
     *
     * @param goodsDTO
     * @return List<GoodVO>
     */
    Result<GoodVO> getGoodDetails(GoodsDTO goodsDTO);

    /**
     * 对商品评分
     *
     * @param score
     * @return Result
     */
    Result getScore(String score);

    /**
     * 商品评论
     *
     * @param commentDTO
     * @return Result
     */
    Result getComment(CommentDTO commentDTO);

}
