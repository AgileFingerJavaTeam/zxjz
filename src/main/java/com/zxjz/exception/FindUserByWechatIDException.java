package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class FindUserByWechatIDException extends BaseException{
    public FindUserByWechatIDException(String message) {
        super(message);
    }

    public FindUserByWechatIDException(String message, Throwable cause) {
        super(message, cause);
    }
}
