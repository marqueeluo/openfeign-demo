package com.luo.demo.openfeign.client.okhttp;

import org.junit.jupiter.api.Test;
import okhttp3.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp 单元测试
 *
 * @author luohq
 * @date 2021-09-12 19:45
 */
public class OkhttpTest {

    @Test
    public void testOkHttp() throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //完整的调用超时时长（默认0不限制，resolving DNS -> connecting -> writing the request body -> server processing -> reading the response body -> redirects + retries
                .callTimeout(Duration.ofSeconds(60))
                //TCP连接超时（默认10s）
                .connectTimeout(Duration.ofSeconds(30))
                //读超时（默认10s）
                .readTimeout(Duration.ofSeconds(30))
                //写超时（默认10s）
                .writeTimeout(Duration.ofSeconds(30))
                //ConnectionPool(5, 5, TimeUnit.MINUTES))
                .connectionPool(new ConnectionPool(60, 1, TimeUnit.MINUTES))
                //new Dispatcher(), maxRequests = 64, maxRequestsPerHost = 5
                //.dispatcher()
                .build();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();

        //TODO SYNC ASYCN
        // client.connectionPool executorService
        // client.dispatcher executorService
        // async.dispatcher maxRequests, maxRequestsPerHost
        Response response = okHttpClient.newCall(request).execute();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            public void onResponse(Call call, Response response)
//                    throws IOException {
//                // ...
//            }
//
//            public void onFailure(Call call, IOException e) {
//                //
//            }
//        });
        System.out.println("resp.status=" + response.code());
        System.out.println("resp.body=" + response.body().string());
    }
}
