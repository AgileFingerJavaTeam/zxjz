package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindUserTypeFailException extends BaseException{
    public FindUserTypeFailException(String message) {
        super(message);
    }

    public FindUserTypeFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
