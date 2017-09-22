package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public enum  UserInfoEnum {

    LOGIN_SUCCESS(1,"登录成功"),
    ACCOUNT_NOT_EXIST(-1,"账号不存在"),
    PSW_ERROR(-2,"密码错误"),
    INNER_ERROR(-3,"数据库内部错误");

    private int code;

    private String codeInfo;

    UserInfoEnum(int code, String codeInfo) {
        this.code = code;
        this.codeInfo = codeInfo;
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

    public static UserInfoEnum stateof(int index) {
        for (UserInfoEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserInfoEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
