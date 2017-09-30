package com.zxjz.exception;

import com.zxjz.base.BaseException;


public class RepeatApplyException extends BaseException{

    public RepeatApplyException(String message) {
        super(message);
    }
    public RepeatApplyException(String message, Throwable cause) {
        super(message, cause);
    }
}
