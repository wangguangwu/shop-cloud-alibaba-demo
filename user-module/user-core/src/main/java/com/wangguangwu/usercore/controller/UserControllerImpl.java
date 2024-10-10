package com.wangguangwu.usercore.controller;

import com.alibaba.fastjson2.JSON;
import com.wangguangwu.beanmodule.UserDTO;
import com.wangguangwu.userapi.api.UserController;
import com.wangguangwu.usercore.service.UserService;
import com.wangguangwu.utilsmodule.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author wangguangwu
 */
@RestController
@Slf4j
public class UserControllerImpl implements UserController {

    @Resource
    private UserService userService;

    @Override
    public Response<UserDTO> getUser(@PathVariable("uid") Long uid) {
        UserDTO user = userService.getUserById(uid);
        log.info("获取到的用户信息为：{}", JSON.toJSONString(user));
        return Response.success(user);
    }
}
