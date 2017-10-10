package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class PaypsdDto {
     private int user_id;
     private String pay_psw;
     private int not_need_psw_period;
     private int is_need_psw;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPay_psw() {
        return pay_psw;
    }

    public void setPay_psw(String pay_psw) {
        this.pay_psw = pay_psw;
    }

    public int getNot_need_psw_period() {
        return not_need_psw_period;
    }

    public void setNot_need_psw_period(int not_need_psw_period) {
        this.not_need_psw_period = not_need_psw_period;
    }

    public int getIs_need_psw() {
        return is_need_psw;
    }

    public void setIs_need_psw(int is_need_psw) {
        this.is_need_psw = is_need_psw;
    }

    @Override
    public String toString() {
        return "PaypsdDto{" +
                "user_id=" + user_id +
                ", pay_psw='" + pay_psw + '\'' +
                ", not_need_psw_period=" + not_need_psw_period +
                ", is_need_psw=" + is_need_psw +
                '}';
    }
}
