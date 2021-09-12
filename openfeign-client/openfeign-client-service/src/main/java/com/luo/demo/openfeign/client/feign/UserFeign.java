package com.luo.demo.openfeign.client.feign;

import com.luo.demo.openfeign.server.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user", url = "http://localhost:8080/demo")
public interface UserFeign extends UserApi {
}
