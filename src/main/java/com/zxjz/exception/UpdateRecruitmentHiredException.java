package com.zxjz.exception;

import com.zxjz.base.BaseException;

import java.util.prefs.BackingStoreException;

public class UpdateRecruitmentHiredException extends BaseException{

    public UpdateRecruitmentHiredException(String message) {
        super(message);
    }

    public UpdateRecruitmentHiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
