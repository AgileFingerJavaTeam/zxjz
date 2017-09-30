package com.zxjz.exception;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class WhetherAdmissionException extends BaseException {
    public WhetherAdmissionException(String message) {
        super(message);
    }

    public WhetherAdmissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
