package com.luo.demo.openfeign.server.controller;

import com.luo.demo.openfeign.server.api.UserApi;
import com.luo.demo.openfeign.server.domain.param.UserAddParam;
import com.luo.demo.openfeign.server.domain.param.UserSearchParam;
import com.luo.demo.openfeign.server.domain.param.UserUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;
import com.luo.demo.openfeign.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户 - Controller
 *
 * @author luohq
 * @date 2021-09-11 16:50
 */
@Controller
@RequestMapping("/user")
public class UserController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @GetMapping("/detail")
    @ResponseBody
    @Override
    public CommonResult<UserResult> getUser(Long id) {
        log.info("get user, param: id={}", id);
        CommonResult<UserResult> commonResult = this.userService.getUserDetail(id);
        log.info("get user, result: {}", commonResult);
        return commonResult;
    }

    @GetMapping("/detail/{userId}")
    @ResponseBody
    @Override
    public CommonResult<UserResult> getPathUser(@PathVariable("userId") Long id) {
        log.info("get path user, param: id={}", id);
        CommonResult<UserResult> commonResult = this.userService.getUserDetail(id);
        log.info("get path user, result: {}", commonResult);
        return commonResult;
    }

    @GetMapping("/list")
    @ResponseBody
    @Override
    public CommonResult<UserResult> getUserList(UserSearchParam userSearchParam) {
        log.info("get user list, param: {}", userSearchParam);
        CommonResult<UserResult> commonResult = this.userService.getUserList(userSearchParam);
        log.info("get user list, result: {}", commonResult);
        return commonResult;
    }

    @PostMapping("/list")
    @ResponseBody
    @Override
    public CommonResult<UserResult> postUserList(UserSearchParam userSearchParam) {
        log.info("post user list, param: {}", userSearchParam);
        CommonResult<UserResult> commonResult = this.userService.getUserList(userSearchParam);
        log.info("post user list, result: {}", commonResult);
        return commonResult;
    }

    @PostMapping("/add")
    @ResponseBody
    @Override
    public CommonResult addUser(@RequestBody UserAddParam userAddParam) {
        log.info("add user, param: {}", userAddParam);
        CommonResult commonResult = this.userService.addUser(userAddParam);
        log.info("add user, result: {}", commonResult);
        return commonResult;
    }


    @PostMapping("/update")
    @ResponseBody
    @Override
    public CommonResult updateUser(@RequestBody UserUpdateParam userUpdateParam) {
        log.info("update user, param: {}", userUpdateParam);
        CommonResult commonResult = this.userService.updateUser(userUpdateParam);
        log.info("update user, result: {}", commonResult);
        return commonResult;
    }
}
