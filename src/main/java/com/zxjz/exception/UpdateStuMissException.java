package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class UpdateStuMissException extends BaseException {
    public UpdateStuMissException(String message) {
        super(message);
    }

    public UpdateStuMissException(String message, Throwable cause) {
        super(message, cause);
    }
}
