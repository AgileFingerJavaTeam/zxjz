package com.zxjz.base;

import com.zxjz.enums.UserInfoEnum;

/**
 * Created by sunzhongyuan on 2017/9/22.
 */
public class BaseExcution {

    protected int code;

    protected String codeInfo;

    public BaseExcution(UserInfoEnum userInfoEnum) {
        this.code = userInfoEnum.getCode();
        this.codeInfo = userInfoEnum.getCodeInfo();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "BaseExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
