package com.luo.demo.openfeign.server.service.impl;

import com.luo.demo.openfeign.server.domain.param.OrgAddParam;
import com.luo.demo.openfeign.server.domain.param.OrgSearchParam;
import com.luo.demo.openfeign.server.domain.param.OrgUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.OrgResult;
import com.luo.demo.openfeign.server.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 组织服务 - 实现类
 *
 * @author luohq
 * @date 2021-09-11 17:02
 */
@Service
public class OrgServiceImpl implements OrgService {

    private static final Logger log = LoggerFactory.getLogger(OrgServiceImpl.class);

    @Override
    public CommonResult<OrgResult> getOrgDetail(Long id) {
        log.info("get org detail, param: id={}", id);
        //MOCK 生成组织信息，实际开发需替换成DAO操作
        OrgResult OrgResult = this.buildOrgResult(id);
        log.info("get org detail, result: {}", OrgResult);
        return CommonResult.successData(OrgResult);
    }

    @Override
    public CommonResult<OrgResult> getOrgList(OrgSearchParam OrgSearchParam) {
        log.info("get org list, param: {}", OrgSearchParam);
        //MOCK 生成组织列表信息，实际开发需替换成DAO操作
        List<OrgResult> OrgResultList = this.buildOrgResults(3);
        log.info("get org list, result: {}", OrgResultList);
        return CommonResult.successRows(OrgResultList, OrgResultList.size());
    }

    @Override
    public CommonResult addOrg(OrgAddParam OrgAddParam) {
        log.info("add org, param: {}", OrgAddParam);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("add org, result: {}", retCount);
        return CommonResult.success();
    }

    @Override
    public CommonResult updateOrg(OrgUpdateParam OrgUpdateParam) {
        log.info("update org, param: {}", OrgUpdateParam);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("update org, result: {}", retCount);
        return CommonResult.success();
    }

    @Override
    public CommonResult deleteOrg(Long id) {
        log.info("delete org, param: id={}", id);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("delete org, result: {}", retCount);
        return CommonResult.success();
    }


    private List<OrgResult> buildOrgResults(Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToLong(Long::valueOf)
                .mapToObj(this::buildOrgResult)
                .collect(Collectors.toList());
    }

    private OrgResult buildOrgResult(Long id) {
        OrgResult OrgResult = new OrgResult();
        OrgResult.setId(id);
        OrgResult.setName("Org-".concat(String.valueOf(id)));
        OrgResult.setParentOrgId(id + 1);
        OrgResult.setCreateTime(LocalDateTime.now());
        OrgResult.setUpdateTime(LocalDateTime.now());
        return OrgResult;
    }
}
