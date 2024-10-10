package com.wangguangwu.usercore.service;

import com.wangguangwu.beanmodule.UserDTO;

/**
 * @author wangguangwu
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     */
    UserDTO getUserById(Long userId);

}
