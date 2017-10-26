package com.zxjz.dto.in;

public class AddMerchantDto {
    private String merchantPhoneNum;
    private int id;
    private int merchantId;
    private int page;
    private int rows;
    private String search_content;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
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

    public String getSearch_content() {
        return search_content;
    }

    public void setSearch_content(String search_content) {
        this.search_content = search_content;
    }

    public String getMerchantPhoneNum() {
        return merchantPhoneNum;
    }

    public void setMerchantPhoneNum(String merchantPhoneNum) {
        this.merchantPhoneNum = merchantPhoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
