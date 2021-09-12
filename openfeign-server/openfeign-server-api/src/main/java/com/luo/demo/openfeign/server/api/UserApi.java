package com.luo.demo.openfeign.server.api;

import com.luo.demo.openfeign.server.domain.param.UserAddParam;
import com.luo.demo.openfeign.server.domain.param.UserSearchParam;
import com.luo.demo.openfeign.server.domain.param.UserUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;
import org.springframework.web.bind.annotation.*;

/**
 * 用户API - 接口定义
 *
 * @author luohq
 * @
 */
@RequestMapping("/user")
public interface UserApi {

    @RequestMapping(value = "/detail", method = {RequestMethod.GET})
    @ResponseBody
    CommonResult<UserResult> getUser(Long id);

    @GetMapping("/detail/{userId}")
    @ResponseBody
    CommonResult<UserResult> getPathUser(@PathVariable("userId") Long id);

    @GetMapping("/list")
    @ResponseBody
    CommonResult<UserResult> getUserList(UserSearchParam userSearchParam);

    @PostMapping("/list")
    @ResponseBody
    CommonResult<UserResult> postUserList(UserSearchParam userSearchParam);

    @PostMapping("/add")
    @ResponseBody
    CommonResult addUser(@RequestBody UserAddParam userAddParam);


    @PostMapping("/update")
    @ResponseBody
    CommonResult updateUser(@RequestBody UserUpdateParam userUpdateParam);

}