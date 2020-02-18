package com.buy.fish.common.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DozerConfig
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/17 15:50
 */
@Configuration
public class DozerConfig {
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozer() {
        //这里是配置文件的路径
//        List<String> mappingFiles = Arrays.asList("dozer/dozer-mapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
//        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
}
