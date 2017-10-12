package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindUserByPhoneFailException extends BaseException{
    public FindUserByPhoneFailException(String message) {
        super(message);
    }

    public FindUserByPhoneFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
