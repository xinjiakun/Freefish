package com.buy.fish.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName FreeFishApplication
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/1/19 17:08
 */
@SpringBootApplication
@ComponentScan("com.buy.fish.*")
@EnableTransactionManagement
@MapperScan("com.buy.fish.dao")
@ImportResource("classpath:*/*.xml")
public class FreeFishApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(FreeFishApplication.class, args);
    }
}
