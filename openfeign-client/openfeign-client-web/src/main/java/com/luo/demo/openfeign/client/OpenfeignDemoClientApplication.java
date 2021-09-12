package com.luo.demo.openfeign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author luohq
 * @date 2021-09-11
 */
@EnableFeignClients
@SpringBootApplication
public class OpenfeignDemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignDemoClientApplication.class, args);
    }

}
