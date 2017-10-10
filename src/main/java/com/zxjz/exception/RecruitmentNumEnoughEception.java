package com.zxjz.exception;

import com.zxjz.base.BaseException;

public class RecruitmentNumEnoughEception extends BaseException{
    public RecruitmentNumEnoughEception(String message) {
        super(message);
    }

    public RecruitmentNumEnoughEception(String message, Throwable cause) {
        super(message, cause);
    }
}
