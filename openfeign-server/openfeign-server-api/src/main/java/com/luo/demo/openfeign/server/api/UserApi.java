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
 * @date 2021-09-14
 */
@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/detail")
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
