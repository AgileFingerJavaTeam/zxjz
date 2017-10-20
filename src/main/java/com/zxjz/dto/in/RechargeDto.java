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
    private  String user_id;
    private String recharge_sequence_number;
    private String q;
    private String merchants_id;
    private String recharge_time;
    private String recharge_mode;
    private String amount_of_recharge;
    private String payment_platform_flow_number;
    private String declare;
    private String operating_staff_id;
    private String serial_number;
    private String actual_amount;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRecharge_sequence_number() {
        return recharge_sequence_number;
    }

    public void setRecharge_sequence_number(String recharge_sequence_number) {
        this.recharge_sequence_number = recharge_sequence_number;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getMerchants_id() {
        return merchants_id;
    }

    public void setMerchants_id(String merchants_id) {
        this.merchants_id = merchants_id;
    }

    public String getRecharge_time() {
        return recharge_time;
    }

    public void setRecharge_time(String recharge_time) {
        this.recharge_time = recharge_time;
    }

    public String getRecharge_mode() {
        return recharge_mode;
    }

    public void setRecharge_mode(String recharge_mode) {
        this.recharge_mode = recharge_mode;
    }

    public String getAmount_of_recharge() {
        return amount_of_recharge;
    }

    public void setAmount_of_recharge(String amount_of_recharge) {
        this.amount_of_recharge = amount_of_recharge;
    }

    public String getPayment_platform_flow_number() {
        return payment_platform_flow_number;
    }

    public void setPayment_platform_flow_number(String payment_platform_flow_number) {
        this.payment_platform_flow_number = payment_platform_flow_number;
    }

    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public String getOperating_staff_id() {
        return operating_staff_id;
    }

    public void setOperating_staff_id(String operating_staff_id) {
        this.operating_staff_id = operating_staff_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(String actual_amount) {
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
                ", user_id='" + user_id + '\'' +
                ", recharge_sequence_number='" + recharge_sequence_number + '\'' +
                ", q='" + q + '\'' +
                ", merchants_id='" + merchants_id + '\'' +
                ", recharge_time='" + recharge_time + '\'' +
                ", recharge_mode='" + recharge_mode + '\'' +
                ", amount_of_recharge='" + amount_of_recharge + '\'' +
                ", payment_platform_flow_number='" + payment_platform_flow_number + '\'' +
                ", declare='" + declare + '\'' +
                ", operating_staff_id='" + operating_staff_id + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", actual_amount='" + actual_amount + '\'' +
                '}';
    }
}
