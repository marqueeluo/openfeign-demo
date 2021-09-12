package com.luo.demo.openfeign.server.service.impl;

import com.luo.demo.openfeign.server.domain.param.UserAddParam;
import com.luo.demo.openfeign.server.domain.param.UserSearchParam;
import com.luo.demo.openfeign.server.domain.param.UserUpdateParam;
import com.luo.demo.openfeign.server.domain.result.CommonResult;
import com.luo.demo.openfeign.server.domain.result.UserResult;
import com.luo.demo.openfeign.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 用户服务 - 实现类
 *
 * @author luohq
 * @date 2021-09-11 17:02
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public CommonResult<UserResult> getUserDetail(Long id) {
        log.info("get user detail, param: id={}", id);
        //MOCK 生成用户信息，实际开发需替换成DAO操作
        UserResult userResult = this.buildUserResult(id);
        log.info("get user detail, result: {}", userResult);
        return CommonResult.successData(userResult);
    }

    @Override
    public CommonResult<UserResult> getUserList(UserSearchParam userSearchParam) {
        log.info("get user list, param: {}", userSearchParam);
        //MOCK 生成用户列表信息，实际开发需替换成DAO操作
        List<UserResult> userResultList = this.buildUserResults(3);
        log.info("get user list, result: {}", userResultList);
        return CommonResult.successRows(userResultList, userResultList.size());
    }

    @Override
    public CommonResult addUser(UserAddParam userAddParam) {
        log.info("add user, param: {}", userAddParam);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("add user, result: {}", retCount);
        return CommonResult.success();
    }

    @Override
    public CommonResult updateUser(UserUpdateParam userUpdateParam) {
        log.info("update user, param: {}", userUpdateParam);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("update user, result: {}", retCount);
        return CommonResult.success();
    }

    @Override
    public CommonResult deleteUser(Long id) {
        log.info("delete user, param: id={}", id);
        //MOCK 实际开发需替换成DAO操作
        int retCount = 1;
        log.info("delete user, result: {}", retCount);
        return CommonResult.success();
    }


    private List<UserResult> buildUserResults(Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToLong(Long::valueOf)
                .mapToObj(this::buildUserResult)
                .collect(Collectors.toList());
    }

    private UserResult buildUserResult(Long id) {
        UserResult userResult = new UserResult();
        userResult.setId(id);
        userResult.setName("Tom-".concat(String.valueOf(id)));
        userResult.setSex(1);
        userResult.setPhone("18888888888");
        userResult.setBornDate(LocalDate.of(2000, 1, 1));
        userResult.setCreateTime(LocalDateTime.now());
        userResult.setUpdateTime(LocalDateTime.now());
        return userResult;
    }
}
