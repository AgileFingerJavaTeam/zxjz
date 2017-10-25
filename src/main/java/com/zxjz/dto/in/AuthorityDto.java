package com.zxjz.dto.in;

public class AuthorityDto {
    private int offset;
    private int rows;
    private String sort;
    private String order;

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

    @Override
    public String toString() {
        return "AuthorityDto{" +
                "offset=" + offset +
                ", rows=" + rows +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
