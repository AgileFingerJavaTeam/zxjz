package com.zxjz.exception.db;

import com.zxjz.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class QueryInnerErrorException extends BaseException{
    public QueryInnerErrorException(String message) {
        super(message);
    }

    public QueryInnerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
