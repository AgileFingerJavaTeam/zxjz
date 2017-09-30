package com.zxjz.exception;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class EnrollJobStatusException extends BaseException{
    public EnrollJobStatusException(String message) {
        super(message);
    }

    public EnrollJobStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
