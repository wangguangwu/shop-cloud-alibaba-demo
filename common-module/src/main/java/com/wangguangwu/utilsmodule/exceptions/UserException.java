package com.wangguangwu.utilsmodule.exceptions;

import com.wangguangwu.utilsmodule.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangguangwu
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Data
public class UserException extends RuntimeException {

    protected final Integer data;
    protected final String message;

    public UserException() {
        this.data = ResponseEnum.USER_SERVER_EXCEPTION.getCode();
        this.message = ResponseEnum.USER_SERVER_EXCEPTION.getMessage();
    }

    public UserException(String message) {
        this.data = ResponseEnum.USER_SERVER_EXCEPTION.getCode();
        this.message = message;
    }
}
