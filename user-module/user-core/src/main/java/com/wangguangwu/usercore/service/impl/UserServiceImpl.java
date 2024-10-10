package com.wangguangwu.usercore.service.impl;

import com.wangguangwu.beanmodule.UserDTO;
import com.wangguangwu.usercore.mapper.UserInfoMapper;
import com.wangguangwu.usercore.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDTO getUserById(Long userId) {
        return Optional.ofNullable(userInfoMapper.selectById(userId))
                .map(userInfoDO -> {
                    UserDTO user = new UserDTO();
                    BeanUtils.copyProperties(userInfoDO, user);
                    return user;
                }).orElse(null);
    }
}
