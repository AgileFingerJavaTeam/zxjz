package com.zxjz.base;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class BaseResult<T> {

    private int state;

    private String error;

    private T data;

    public BaseResult(int state, String error) {
        this.state = state;
        this.error = error;
    }

    public BaseResult(int state, T data) {
        this.state = state;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "state=" + state +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}
