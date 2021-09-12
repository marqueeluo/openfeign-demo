package com.luo.demo.openfeign.server.service;

import com.luo.demo.openfeign.server.domain.param.UserAddParam;
import com.luo.demo.openfeign.server.domain.param.UserSearchParam;
import com.luo.demo.openfeign.server.domain.param.UserUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;

/**
 * 用户服务 - 接口
 *
 * @author luohq
 * @date 2021-09-11 16:58
 */
public interface UserService {
    CommonResult<UserResult> getUserDetail(Long id);

    CommonResult<UserResult> getUserList(UserSearchParam userSearchParam);

    CommonResult addUser(UserAddParam userAddParam);

    CommonResult updateUser(UserUpdateParam userUpdateParam);

    CommonResult deleteUser(Long id);
}
