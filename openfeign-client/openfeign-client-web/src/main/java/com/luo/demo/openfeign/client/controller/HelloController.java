package com.luo.demo.openfeign.client.controller;

import com.luo.demo.openfeign.client.feign.UserFeign;
import com.luo.demo.openfeign.server.domain.param.UserAddParam;
import com.luo.demo.openfeign.server.domain.param.UserSearchParam;
import com.luo.demo.openfeign.server.domain.param.UserUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;
import org.apache.catalina.User;
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
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private UserFeign userFeign;

    @RequestMapping("/hello")
    @ResponseBody
    public CommonResult hello() {
        Long id = 1L;
        CommonResult<UserResult> commonResult = null;
        /** GET TODO 405 Method Not Support 实际请求为POST请求 */
        commonResult = this.userFeign.getUser(id);
        log.info("feign getUser, result: {}", commonResult);
//        /** PathVariable */
//        commonResult = this.userFeign.getPathUser(id);
//        log.info("feign getPathUser, result: {}", commonResult);
//
//        /** GET queryString TODO 服务端收到参数为空 */
//        commonResult = this.userFeign.getUserList(this.buildUserSearchParam());
//        log.info("feign getUserList, result: {}", commonResult);
//
//        /** POST FORM TODO 服务端收到参数为空  */
//        commonResult = this.userFeign.postUserList(this.buildUserSearchParam());
//        log.info("feign postUserList, result: {}", commonResult);
//
//        /** POST RequestBody */
//        commonResult = this.userFeign.addUser(this.buildUserAddParam());
//        log.info("feign addUser, result: {}", commonResult);
//        commonResult = this.userFeign.updateUser(this.buildUserUpdateParam());
//        log.info("feign updateUser, result: {}", commonResult);
//
        return CommonResult.success();
    }


    private UserSearchParam buildUserSearchParam() {
        UserSearchParam userSearchParam = new UserSearchParam();
        userSearchParam.setName("tom");
        userSearchParam.setSex(1);
        userSearchParam.setBornDateStart(LocalDate.of(1990, 1, 1));
        userSearchParam.setBornDateEnd(LocalDate.of(2021, 1, 1));
        userSearchParam.setPhone("18888888888");
        return userSearchParam;
    }
    private UserAddParam buildUserAddParam() {
        UserAddParam userAddParam = new UserAddParam();
        userAddParam.setName("tom");
        userAddParam.setSex(1);
        userAddParam.setBornDate(LocalDate.now());
        userAddParam.setPhone("18888888888");
        return userAddParam;
    }


    private UserUpdateParam buildUserUpdateParam() {
        UserUpdateParam userUpdateParam = new UserUpdateParam();
        userUpdateParam.setId(1L);
        userUpdateParam.setName("tom");
        userUpdateParam.setSex(1);
        userUpdateParam.setBornDate(LocalDate.now());
        userUpdateParam.setPhone("18888888888");
        return userUpdateParam;
    }

}
