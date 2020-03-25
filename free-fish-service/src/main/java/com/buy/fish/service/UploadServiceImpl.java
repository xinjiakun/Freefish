package com.buy.fish.service;

import com.buy.fish.dao.TbGoodMapper;
import com.buy.fish.dao.TbUserMapper;
import com.buy.fish.dto.entity.TbGoodPO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService{
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Resource
    private TbGoodMapper tbGoodMapper;

    @Override
    public int uploadNewGood(Integer userId, String goodtitle , String goodsubtitle , Integer goodprice, Integer goodtype, Integer goodold,Integer goodpostage, MultipartFile aliImg1, MultipartFile[] aliImg2) {
        String pathName = "E:/graduate-prj/Freefish/pic/";//想要存储文件的地址
        String pname1 = aliImg1.getOriginalFilename();//获取文件名（包括后缀）
        String[] pname2 = new String[4];

        //图片存到本地路径
        filex(aliImg1,pathName+pname1);
        for(int i =0;i<aliImg2.length;i++){
            String pname = aliImg2[i].getOriginalFilename();
            filex(aliImg2[i],pathName+pname);
            pname2[i]=pathName+pname;
        }

        TbGoodPO tbGoodPO = new TbGoodPO();
        tbGoodPO.setAliImage(pathName+pname1);
        tbGoodPO.setAliImages1(pname2[0]);
        tbGoodPO.setAliImages2(pname2[1]);
        tbGoodPO.setAliImages3(pname2[2]);
        tbGoodPO.setAliImages4(pname2[3]);
        tbGoodPO.setOldOr(goodold);
        tbGoodPO.setTypeOb(goodtype);
        tbGoodPO.setPrice(goodprice);
        tbGoodPO.setPostage(goodpostage);
        tbGoodPO.setUserId(userId);
        tbGoodPO.setTitle(goodtitle);
        tbGoodPO.setSubTitle(goodsubtitle);

        try{
            tbGoodMapper.insert(tbGoodPO);
            logger.info("用户商品插入成功");
            return 1;
        }catch (Exception e){
            logger.error("商品上传错误",e);
            return 0;
        }

    }

    public String filex(MultipartFile file,String pname){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pname);
            fos.write(file.getBytes()); // 写入文件
            //System.out.println("文件上传成功");
            return "文件上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "文件上传失败";
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
