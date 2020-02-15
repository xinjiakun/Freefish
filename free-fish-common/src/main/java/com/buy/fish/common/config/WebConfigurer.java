package com.buy.fish.common.config;

import com.buy.fish.common.config.converter.EnumConvertFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfigurer
 * @Description 请求配置
 * @Author xinjiakun
 * @Date 2020/2/8 18:31
 */
@Configuration
@EnableAspectJAutoProxy
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private EnumConvertFactory enumConvertFactory;

    /**
     * 跨域拦截
     *
     * @param registry
     *
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
    /**
     * 枚举解析
     *
     * @param registry
     *
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumConvertFactory);
    }
}
