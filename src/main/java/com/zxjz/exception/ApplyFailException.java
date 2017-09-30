package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class ApplyFailException extends BaseException {
    public ApplyFailException(String message) {
        super(message);
    }

    public ApplyFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
