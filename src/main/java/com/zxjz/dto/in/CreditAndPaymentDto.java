package com.zxjz.dto.in;

public class CreditAndPaymentDto {
   private String bxw_search_content;
    private String sort;
    private String order;
    private int offset;
    private int rows;
    private int user_id;
    private  double credit_total;
    private String payment_days;
    private  int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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

    public double getCredit_total() {
        return credit_total;
    }

    public void setCredit_total(double credit_total) {
        this.credit_total = credit_total;
    }

    public String getPayment_days() {
        return payment_days;
    }

    public void setPayment_days(String payment_days) {
        this.payment_days = payment_days;
    }

    @Override
    public String toString() {
        return "CreditAndPaymentDto{" +
                "bxw_search_content='" + bxw_search_content + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", offset=" + offset +
                ", rows=" + rows +
                ", user_id=" + user_id +
                ", credit_total=" + credit_total +
                ", payment_days=" + payment_days +
                ", page=" + page +
                '}';
    }
}
