package com.wangguangwu.userapi.api;

import com.wangguangwu.beanmodule.UserDTO;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangguangwu
 */
@RequestMapping("/user")
public interface UserController {

    /**
     * 获取用户信息接口定义
     *
     * @param uid 用户ID
     * @return 用户信息
     */
    @GetMapping("/get/{uid}")
    Response<UserDTO> getUser(@PathVariable("uid") Long uid);

}
