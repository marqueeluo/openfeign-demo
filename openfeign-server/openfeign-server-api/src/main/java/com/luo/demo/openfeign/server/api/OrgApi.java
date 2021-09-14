package com.luo.demo.openfeign.server.api;

import com.luo.demo.openfeign.server.domain.param.OrgAddParam;
import com.luo.demo.openfeign.server.domain.param.OrgSearchParam;
import com.luo.demo.openfeign.server.domain.param.OrgUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.OrgResult;
import org.springframework.web.bind.annotation.*;

/**
 * 组织API - 接口定义
 *
 * @author luohq
 * @date 2021-09-14
 */
@RequestMapping("/org")
public interface OrgApi {

    @GetMapping("/detail")
    @ResponseBody
    CommonResult<OrgResult> getOrg(@RequestParam Long id);

    @GetMapping("/list")
    @ResponseBody
    CommonResult<OrgResult> getOrgList(OrgSearchParam orgSearchParam);


    @PostMapping("/add")
    @ResponseBody
    CommonResult addOrg(@RequestBody OrgAddParam orgAddParam);


    @PostMapping("/update")
    @ResponseBody
    CommonResult updateOrg(@RequestBody OrgUpdateParam orgUpdateParam);

    @DeleteMapping("/delete")
    @ResponseBody
    CommonResult deleteOrg(@RequestParam("id") Long id);

}
