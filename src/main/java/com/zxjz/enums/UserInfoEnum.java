package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public enum  UserInfoEnum {

    LOGIN_SUCCESS(1,"登录成功"),
    ACCOUNT_NOT_EXIST(-1,"账号不存在"),
    PSW_ERROR(-2,"密码错误"),
    INNER_ERROR(-3,"数据库内部错误");

    private int state;

    private String stateInfo;

    UserInfoEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static UserInfoEnum stateof(int index) {
        for (UserInfoEnum state : values())
        {
            if (state.getState()==index)
            {
                return state;
            }
        }
        return null;
    }
}
