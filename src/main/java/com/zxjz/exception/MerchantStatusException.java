package com.zxjz.exception;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class MerchantStatusException extends BaseException {
    public MerchantStatusException(String message) {
        super(message);
    }

    public MerchantStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
