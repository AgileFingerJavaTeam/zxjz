package com.zxjz.enums;

public enum RegistrationEnum {
    FIND_SUCCESS(1),//查询成功
    FIND_ERROR(-1),//查询错误
    REGISTER_SUCCESS(2),//注册成功
    REGISTER_FAIL(-2),//注册失败
    NO_VERIFY_CODE(-3),//验证码错误
    ALREADY_REGISTER(4),//手机号已注册
    NO_REGISTER(-4),//手机号没有注册
    MODIFICATION_SUCCESS(5),//密码修改成功
    MODIFICATION_ERROR(-5),//密码修改失败
    NEWPADTHEOLDPAD(-6),//新密码与旧密码一致
    PSD_ERROR(-7),//密码错误
    NO_USER_INFO(-8),//没用用户信息
    SUBMIT_SUCCESS(9),//提交成功
    SUBMIT_FAIL(-9),//提交失败
    APPROVALING_NOW(10),//审核中
    SEND_NSG_SUCCESS(11),//发送信息成功
    SEND_NSG_FAIL(-11),//发送信息失败
    NO_PRAM(-12),//缺少参数
    PHONEADNPWD_ERROR(-13),//手机号和密码输入错误
    SAVE_USER_INFO_SUCCESS(14),//保存信息成功
    SAVE_USER_INFO_FAIL(-14);//保存信息失败

    private int code;

    RegistrationEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
