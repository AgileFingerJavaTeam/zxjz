package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindJobException extends BaseException {
    public FindJobException(String message) {
        super(message);
    }

    public FindJobException(String message, Throwable cause) {
        super(message, cause);
    }
}
