package com.buy.fish.service;

import com.buy.fish.common.pojo.Result;
import com.buy.fish.dto.request.CommentDTO;
import com.buy.fish.dto.request.GoodsDTO;
import com.buy.fish.dto.response.GoodVO;
import org.springframework.stereotype.Component;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/15 17:43
 */
@Component
public class ItemServiceImpl implements ItemService {
    @Override
    public Result<GoodVO> getGoodDetails(GoodsDTO goodsDTO) {
        return null;
    }

    @Override
    public Result getScore(String score) {
        return null;
    }

    @Override
    public Result getComment(CommentDTO commentDTO) {
        return null;
    }
}
