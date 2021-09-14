package com.luo.demo.openfeign.server.service;

import com.luo.demo.openfeign.server.domain.param.OrgAddParam;
import com.luo.demo.openfeign.server.domain.param.OrgSearchParam;
import com.luo.demo.openfeign.server.domain.param.OrgUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.OrgResult;

/**
 * 组织服务 - 接口
 *
 * @author luohq
 * @date 2021-09-11 16:58
 */
public interface OrgService {
    CommonResult<OrgResult> getOrgDetail(Long id);

    CommonResult<OrgResult> getOrgList(OrgSearchParam OrgSearchParam);

    CommonResult addOrg(OrgAddParam OrgAddParam);

    CommonResult updateOrg(OrgUpdateParam OrgUpdateParam);

    CommonResult deleteOrg(Long id);
}
