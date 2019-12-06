package com.buy.fish.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author xinjiakun
 * @title: SwaggerConfig
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 18:28
 */
@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    private String port;

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.buy.fish.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    protected ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("闲置交易平台")
                .description("闲置交易平台 Spring Boot Restful Api Document.")
                .termsOfServiceUrl("http://www.github.com/kongchen/swagger-maven-plugin")
                .version("1.0.0").license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
