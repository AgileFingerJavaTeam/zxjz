package com.zxjz.dto.in;

public class VIPMerchantAccountDto {
    private String sort;
    private String order;
    private int offset;
    private int rows;
    private String hzn_vipMersearch_content;
    private int user_id;
    private String vip_start;
    private String vip_end;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVip_start() {
        return vip_start;
    }

    public void setVip_start(String vip_start) {
        this.vip_start = vip_start;
    }

    public String getVip_end() {
        return vip_end;
    }

    public void setVip_end(String vip_end) {
        this.vip_end = vip_end;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getHzn_vipMersearch_content() {
        return hzn_vipMersearch_content;
    }

    public void setHzn_vipMersearch_content(String hzn_vipMersearch_content) {
        this.hzn_vipMersearch_content = hzn_vipMersearch_content;
    }

    @Override
    public String toString() {
        return "VIPMerchantAccountDto{" +
                "sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", offset=" + offset +
                ", rows=" + rows +
                ", hzn_vipMersearch_content='" + hzn_vipMersearch_content + '\'' +
                ", user_id=" + user_id +
                ", vip_start='" + vip_start + '\'' +
                ", vip_end='" + vip_end + '\'' +
                ", id=" + id +
                '}';
    }
}
