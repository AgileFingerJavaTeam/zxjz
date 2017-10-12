package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindPhonePasswordFailException extends BaseException{
    public FindPhonePasswordFailException(String message) {
        super(message);
    }

    public FindPhonePasswordFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
