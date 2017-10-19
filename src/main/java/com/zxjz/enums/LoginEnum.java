package com.zxjz.enums;

public enum LoginEnum {
    ACCOUNTNUM_IS_NO(-1),//账号不存在
    PAW_MISTAKE(-2),//密码错误
    LOG_IN_SUCESS(3),//登陆成功
    LOG_IN_FALL(-3);//登陆失败

    private int code;

    LoginEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "LoginEnum{" +
                "code=" + code +
                '}';
    }
}
