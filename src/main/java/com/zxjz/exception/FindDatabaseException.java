package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindDatabaseException extends BaseException {
    public FindDatabaseException(String message) {
        super(message);
    }

    public FindDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
