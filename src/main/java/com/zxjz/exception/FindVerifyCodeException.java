package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindVerifyCodeException extends BaseException{
    public FindVerifyCodeException(String message) {
        super(message);
    }

    public FindVerifyCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
