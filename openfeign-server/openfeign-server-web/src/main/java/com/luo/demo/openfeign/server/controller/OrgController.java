package com.luo.demo.openfeign.server.controller;

import com.luo.demo.openfeign.server.api.OrgApi;
import com.luo.demo.openfeign.server.domain.param.OrgAddParam;
import com.luo.demo.openfeign.server.domain.param.OrgSearchParam;
import com.luo.demo.openfeign.server.domain.param.OrgUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.OrgResult;
import com.luo.demo.openfeign.server.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 组织管理 - controller
 *
 * @author luohq
 * @date 2021-09-14 19:47
 */
@Controller
@RequestMapping("/org")
public class OrgController implements OrgApi {
    private static final Logger log = LoggerFactory.getLogger(OrgController.class);

    @Resource
    private OrgService orgService;

    @GetMapping("/detail")
    @ResponseBody
    @Override
    public CommonResult<OrgResult> getOrg(@RequestParam Long id) {
        log.info("get org, param: id={}", id);
        CommonResult<OrgResult> commonResult = this.orgService.getOrgDetail(id);
        log.info("get org, result: {}", commonResult);
        return commonResult;
    }

    @GetMapping("/list")
    @ResponseBody
    @Override
    public CommonResult<OrgResult> getOrgList(OrgSearchParam orgSearchParam) {
        log.info("get org list, param: {}", orgSearchParam);
        CommonResult<OrgResult> commonResult = this.orgService.getOrgList(orgSearchParam);
        log.info("get org list, result: {}", commonResult);
        return commonResult;
    }


    @PostMapping("/add")
    @ResponseBody
    @Override
    public CommonResult addOrg(@RequestBody OrgAddParam orgAddParam) {
        log.info("add org, param: {}", orgAddParam);
        CommonResult commonResult = this.orgService.addOrg(orgAddParam);
        log.info("add org, result: {}", commonResult);
        return commonResult;
    }


    @PostMapping("/update")
    @ResponseBody
    @Override
    public CommonResult updateOrg(@RequestBody OrgUpdateParam orgUpdateParam) {
        log.info("update org, param: {}", orgUpdateParam);
        CommonResult commonResult = this.orgService.updateOrg(orgUpdateParam);
        log.info("update org, result: {}", commonResult);
        return commonResult;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    @Override
    public CommonResult deleteOrg(@RequestParam("id") Long id) {
        log.info("delete org, param: id={}", id);
        CommonResult<OrgResult> commonResult = this.orgService.deleteOrg(id);
        log.info("delete org, result: {}", commonResult);
        return commonResult;
    }

}
