package com.zxjz.enums;

public enum RegistrationEnum {
    FIND_SUCCESS(1,"查询成功"),
    FIND_ERROR(-1,"查询错误"),
    REGISTER_SUCCESS(2,"注册成功"),
    REGISTER_FAIL(-2,"注册失败"),
    NO_VERIFY_CODE(-3,"验证码错误"),
    NO_REGISTER(-4,"手机号没有注册"),
    MODIFICATION_SUCCESS(5,"密码修改成功"),
    MODIFICATION_ERROR(-5,"密码修改失败"),
    NEWPADTHEOLDPAD(-6,"新密码与旧密码一致"),
    PSD_ERROR(-7,"密码错误"),
    NO_USER_INFO(-8,"没用用户信息"),
    SUBMIT_SUCCESS(9,"提交成功"),
    SUBMIT_FAIL(-9,"提交失败"),
    APPROVALING_NOW(10,"审核中");
    private int code;
    private String codeInfo;

    RegistrationEnum(int code, String codeInfo) {
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

    @Override
    public String toString() {
        return "RegistrationEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }

    public static RegistrationEnum stateof(int index) {
        for (RegistrationEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }
}
