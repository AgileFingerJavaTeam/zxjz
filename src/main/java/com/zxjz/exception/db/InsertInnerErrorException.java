package com.zxjz.exception.db;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class InsertInnerErrorException extends BaseException {
    public InsertInnerErrorException(String message) {
        super(message);
    }

    public InsertInnerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
