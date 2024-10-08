package com.wangguangwu.utilsmodule.exceptions;

import com.wangguangwu.utilsmodule.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用业务异常。
 *
 * @author wangguangwu
 */
@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonServiceException extends RuntimeException {

    protected final Integer data;
    protected final String message;

    public CommonServiceException() {
        this.data = ResponseEnum.SERVICE_UNKNOWN.getCode();
        this.message = ResponseEnum.SERVICE_UNKNOWN.getMessage();
    }

    public CommonServiceException(String message) {
        this.data = ResponseEnum.SERVICE_UNKNOWN.getCode();
        this.message = message;
    }

}
