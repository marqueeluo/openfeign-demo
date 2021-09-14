package com.luo.demo.openfeign.client.controller;

import com.luo.demo.openfeign.server.api.OrgApi;
import com.luo.demo.openfeign.server.api.UserApi;
import com.luo.demo.openfeign.server.domain.param.*;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.OrgResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * Hello controller
 *
 * @author luohq
 * @date 2021-09-11 20:53
 */
@Controller
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private UserApi userApi;

    @Resource
    private OrgApi orgApi;

    @RequestMapping("/user")
    @ResponseBody
    public CommonResult hello() {
        Long id = 1L;
        CommonResult<UserResult> commonResult = null;
        /** GET */
        commonResult = this.userApi.getUser(id);
        log.info("feign getUser, result: {}\n", commonResult);

        /** PathVariable */
        commonResult = this.userApi.getPathUser(id);
        log.info("feign getPathUser, result: {}\n", commonResult);

        /** GET queryString（若使用原SpringMvcContract服务端收到参数为空） */
        commonResult = this.userApi.getUserList(this.buildUserSearchParam());
        log.info("feign getUserList, result: {}\n", commonResult);

        /** POST FORM（若使用原SpringMvcContract服务端收到参数为空） */
        commonResult = this.userApi.postUserList(this.buildUserSearchParam());
        log.info("feign postUserList, result: {}\n", commonResult);

        /** POST RequestBody */
        commonResult = this.userApi.addUser(this.buildUserAddParam());
        log.info("feign addUser, result: {}\n", commonResult);
        commonResult = this.userApi.updateUser(this.buildUserUpdateParam());
        log.info("feign updateUser, result: {}\n", commonResult);

        return CommonResult.success();
    }

    @RequestMapping("/org")
    @ResponseBody
    public CommonResult org() {
        Long id = 1L;
        CommonResult<OrgResult> commonResult = null;
        /** GET */
        commonResult = this.orgApi.getOrg(id);
        log.info("feign getOrg, result: {}\n", commonResult);

        /** GET queryString（若使用原SpringMvcContract服务端收到参数为空） */
        commonResult = this.orgApi.getOrgList(this.buildOrgSearchParam());
        log.info("feign getOrgList, result: {}\n", commonResult);

        /** POST RequestBody */
        commonResult = this.orgApi.addOrg(this.buildOrgAddParam());
        log.info("feign addOrg, result: {}\n", commonResult);
        commonResult = this.orgApi.updateOrg(this.buildOrgUpdateParam());
        log.info("feign updateOrg, result: {}\n", commonResult);

        /** DELETE */
        commonResult = this.orgApi.deleteOrg(id);
        log.info("feign deleteOrg, result: {}\n", commonResult);

        return CommonResult.success();
    }


    private UserSearchParam buildUserSearchParam() {
        UserSearchParam userSearchParam = new UserSearchParam();
        userSearchParam.setName("小明");
        userSearchParam.setSex(1);
        userSearchParam.setBornDateStart(LocalDate.of(1990, 1, 1));
        userSearchParam.setBornDateEnd(LocalDate.of(2021, 1, 1));
        userSearchParam.setPhone("18888888888");
        return userSearchParam;
    }

    private UserAddParam buildUserAddParam() {
        UserAddParam userAddParam = new UserAddParam();
        userAddParam.setName("小明");
        userAddParam.setSex(1);
        userAddParam.setBornDate(LocalDate.now());
        userAddParam.setPhone("18888888888");
        return userAddParam;
    }


    private UserUpdateParam buildUserUpdateParam() {
        UserUpdateParam userUpdateParam = new UserUpdateParam();
        userUpdateParam.setId(1L);
        userUpdateParam.setName("小明");
        userUpdateParam.setSex(1);
        userUpdateParam.setBornDate(LocalDate.now());
        userUpdateParam.setPhone("18888888888");
        return userUpdateParam;
    }


    private OrgSearchParam buildOrgSearchParam() {
        OrgSearchParam orgSearchParam = new OrgSearchParam();
        orgSearchParam.setName("云平台业务部");
        orgSearchParam.setId(1L);
        orgSearchParam.setParentId(11L);
        orgSearchParam.setCreateDateStart(LocalDate.of(1990, 1, 1));
        orgSearchParam.setCreateDateEnd(LocalDate.of(2021, 1, 1));
        return orgSearchParam;
    }

    private OrgAddParam buildOrgAddParam() {
        OrgAddParam orgAddParam = new OrgAddParam();
        orgAddParam.setName("云平台业务部");
        orgAddParam.setParentOrgId(11L);
        return orgAddParam;
    }


    private OrgUpdateParam buildOrgUpdateParam() {
        OrgUpdateParam orgUpdateParam = new OrgUpdateParam();
        orgUpdateParam.setId(1L);
        orgUpdateParam.setName("云平台业务部");
        orgUpdateParam.setParentOrgId(11L);
        return orgUpdateParam;
    }


}
