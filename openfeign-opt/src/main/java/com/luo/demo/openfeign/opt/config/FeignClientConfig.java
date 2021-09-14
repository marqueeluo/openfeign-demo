package com.luo.demo.openfeign.opt.config;

import com.luo.demo.openfeign.opt.contract.SpringMvcContractOpt;
import feign.Contract;
import feign.Logger;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignClient - 配置
 *
 * TODO 配置项目待提取 配置okhttp3 的连接池相关
 *
 * @author luohq
 * @date 2021-09-14
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public feign.okhttp.OkHttpClient client() {
//        return new feign.okhttp.OkHttpClient(new OkHttpClient.Builder()
//                //完整的调用超时时长（默认0不限制，resolving DNS -> connecting -> writing the request body -> server processing -> reading the response body -> redirects + retries
//                .callTimeout(Duration.ofSeconds(60))
//                //TCP连接超时（默认10s） - 会被feign.client.config.default.connectTimeout（默认10s）覆盖
//                .connectTimeout(Duration.ofSeconds(30))
//                //读超时（默认10s） - 会被feign.client.config.default.readTimeout（默认60s）覆盖
//                .readTimeout(Duration.ofSeconds(30))
//                //写超时（默认10s）
//                .writeTimeout(Duration.ofSeconds(30))
//                //ConnectionPool(5, 5, TimeUnit.MINUTES)) - TODO 需根据QPS设置连接池
//                .connectionPool(new ConnectionPool(60, 1, TimeUnit.MINUTES))
//                //new Dispatcher(), maxRequests = 64, maxRequestsPerHost = 5
//                //.dispatcher()
//                .build());
        return new feign.okhttp.OkHttpClient();
    }

    @Bean
    public Contract feignContract() {
        return new SpringMvcContractOpt();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
