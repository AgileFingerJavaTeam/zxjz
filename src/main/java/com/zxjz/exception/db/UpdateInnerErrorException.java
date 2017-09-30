package com.zxjz.exception.db;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class UpdateInnerErrorException extends BaseException{
    public UpdateInnerErrorException(String message) {
        super(message);
    }

    public UpdateInnerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
