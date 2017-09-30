package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class UpdateDatabaseException extends BaseException {
    public UpdateDatabaseException(String message) {
        super(message);
    }

    public UpdateDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
