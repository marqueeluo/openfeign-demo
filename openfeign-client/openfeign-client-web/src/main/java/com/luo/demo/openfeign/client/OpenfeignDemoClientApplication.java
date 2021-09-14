package com.luo.demo.openfeign.client;

import com.luo.demo.openfeign.opt.anno.EnableFeignClientsOpt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author luohq
 * @date 2021-09-11
 */
@EnableFeignClientsOpt
@SpringBootApplication
public class OpenfeignDemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignDemoClientApplication.class, args);
    }

}
