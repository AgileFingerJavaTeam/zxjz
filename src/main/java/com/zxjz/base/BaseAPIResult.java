package com.zxjz.base;

/**
 * Created by sunzhongyuan on 2017/10/12.
 */
public class BaseAPIResult {

    //接口状态  0:失败 1:成功
    private int state;

    private int code;

    //携带数据
    private Object data;


    public BaseAPIResult(int state, BaseAPIExcution baseAPIExcution) {
        this.state = state;
        this.code = baseAPIExcution.getCode();
        this.data = baseAPIExcution.getData();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
