package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class RechargeDto {
    private String bxw_search_content;
    private String sort;
    private String order;
    private int page;
    private int rows;
    private  int user_id;
    private int recharge_sequence_number;
    private String q;
    private int merchants_id;
    private String recharge_time;
    private int recharge_mode;
    private double amount_of_recharge;
    private int payment_platform_flow_number;
    private String declare;
    private int operating_staff_id;
    private int serial_number;
    private double actual_amount;

    public String getBxw_search_content() {
        return bxw_search_content;
    }

    public void setBxw_search_content(String bxw_search_content) {
        this.bxw_search_content = bxw_search_content;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRecharge_sequence_number() {
        return recharge_sequence_number;
    }

    public void setRecharge_sequence_number(int recharge_sequence_number) {
        this.recharge_sequence_number = recharge_sequence_number;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getMerchants_id() {
        return merchants_id;
    }

    public void setMerchants_id(int merchants_id) {
        this.merchants_id = merchants_id;
    }

    public String getRecharge_time() {
        return recharge_time;
    }

    public void setRecharge_time(String recharge_time) {
        this.recharge_time = recharge_time;
    }

    public int getRecharge_mode() {
        return recharge_mode;
    }

    public void setRecharge_mode(int recharge_mode) {
        this.recharge_mode = recharge_mode;
    }

    public double getAmount_of_recharge() {
        return amount_of_recharge;
    }

    public void setAmount_of_recharge(double amount_of_recharge) {
        this.amount_of_recharge = amount_of_recharge;
    }

    public int getPayment_platform_flow_number() {
        return payment_platform_flow_number;
    }

    public void setPayment_platform_flow_number(int payment_platform_flow_number) {
        this.payment_platform_flow_number = payment_platform_flow_number;
    }

    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public int getOperating_staff_id() {
        return operating_staff_id;
    }

    public void setOperating_staff_id(int operating_staff_id) {
        this.operating_staff_id = operating_staff_id;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public double getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(double actual_amount) {
        this.actual_amount = actual_amount;
    }

    @Override
    public String toString() {
        return "RechargeDto{" +
                "bxw_search_content='" + bxw_search_content + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", user_id=" + user_id +
                ", recharge_sequence_number=" + recharge_sequence_number +
                ", q='" + q + '\'' +
                ", merchants_id=" + merchants_id +
                ", recharge_time='" + recharge_time + '\'' +
                ", recharge_mode=" + recharge_mode +
                ", amount_of_recharge=" + amount_of_recharge +
                ", payment_platform_flow_number=" + payment_platform_flow_number +
                ", declare='" + declare + '\'' +
                ", operating_staff_id=" + operating_staff_id +
                ", serial_number=" + serial_number +
                ", actual_amount=" + actual_amount +
                '}';
    }
}
