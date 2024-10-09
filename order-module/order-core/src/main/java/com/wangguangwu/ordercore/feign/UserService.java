package com.wangguangwu.ordercore.feign;

import com.wangguangwu.beanmodule.UserDTO;
import com.wangguangwu.ordercore.feign.fallback.UserServiceFallBackFactory;
import com.wangguangwu.utilsmodule.constant.ServiceConstants;
import com.wangguangwu.utilsmodule.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangguangwu
 */
@FeignClient(value = ServiceConstants.USER_SERVER, fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {

    /**
     * 查询用户信息
     *
     * @param uid 用户id
     * @return 用户信息
     */
    @GetMapping(value = "/user/get/{uid}")
    Response<UserDTO> getUser(@PathVariable("uid") Long uid);

}
