package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class MerchantFundsReceivableInfo {
    private int user_id;//商户ID
    private int serial_number;//应收款序号
    private String Arrears_time;//欠款时间
    private String clear_num;//结算序号
    private String deductedS;//应扣款金额
    private String deductedI;//实扣款金额
    private String actual_amount;//应收金额
    private String is_back;//是否收回
    private String back_time;//收回日期
    private int prepaid_number;//充值序号
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getSerial_number() {
        return serial_number;
    }
    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }
    public String getArrears_time() {
        return Arrears_time;
    }
    public void setArrears_time(String arrears_time) {
        Arrears_time = arrears_time;
    }
    public String getClear_num() {
        return clear_num;
    }
    public void setClear_num(String clear_num) {
        this.clear_num = clear_num;
    }
    public String getDeductedS() {
        return deductedS;
    }
    public void setDeductedS(String deductedS) {
        this.deductedS = deductedS;
    }
    public String getDeductedI() {
        return deductedI;
    }
    public void setDeductedI(String deductedI) {
        this.deductedI = deductedI;
    }
    public String getActual_amount() {
        return actual_amount;
    }
    public void setActual_amount(String actual_amount) {
        this.actual_amount = actual_amount;
    }
    public String getIs_back() {
        return is_back;
    }
    public void setIs_back(String is_back) {
        this.is_back = is_back;
    }
    public String getBack_time() {
        return back_time;
    }
    public void setBack_time(String back_time) {
        this.back_time = back_time;
    }
    public int getPrepaid_number() {
        return prepaid_number;
    }
    public void setPrepaid_number(int prepaid_number) {
        this.prepaid_number = prepaid_number;
    }
    @Override
    public String toString() {
        return "MerchantFundsReceivableInfo [user_id=" + user_id + ", serial_number=" + serial_number
                + ", Arrears_time=" + Arrears_time + ", clear_num=" + clear_num + ", deductedS=" + deductedS
                + ", deductedI=" + deductedI + ", actual_amount=" + actual_amount + ", is_back=" + is_back
                + ", back_time=" + back_time + ", prepaid_number=" + prepaid_number + "]";
    }


}
