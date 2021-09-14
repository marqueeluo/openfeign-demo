package com.luo.demo.openfeign.client.feign;

import com.luo.demo.openfeign.server.api.OrgApi;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(name = "org", url = "http://localhost:8080/demo")
public interface OrgFeign extends OrgApi {
}
