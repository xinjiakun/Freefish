package com.buy.fish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author xinjiakun
 * @title: SpringBootMain
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 9:43
 */
@SpringBootApplication
//@PropertySources(value = {
//        @PropertySource( )
//})
@EnableSwagger2
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
