package com.buy.fish.service;

import com.buy.fish.dto.entity.TbGoodPO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 用户发布新商品
     * zsj
     * @param
     * @return
     */
    int uploadNewGood(Integer userId, String goodtitle , String goodsubtitle , Integer goodprice, Integer goodtype, Integer goodold,Integer goodpostage, MultipartFile aliImg1, MultipartFile[] aliImg2);
}
