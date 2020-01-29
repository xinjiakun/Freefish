package com.buy.fish.common.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author 辛佳锟
 * @title: MyCommandLineRunner
 * @projectName FreeFish
 * @description: TODO
 * @date 2020/01/19 16:01
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

    public void run(String... args) throws Exception {
        try {
            Runtime.getRuntime().exec("cmd /c start http:localhost:" + port + "/swagger-ui.html#/");
            Runtime.getRuntime().exec("cmd /c start http:localhost:" + port);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
