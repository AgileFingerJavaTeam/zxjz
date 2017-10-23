package com.zxjz.dto.in;

public class StuMsgDto {
    private  int user_id;
    private  int rows;
    private  int page;
    private String sort;
    private String order;
    private  String bxw_search_content;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

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
}
