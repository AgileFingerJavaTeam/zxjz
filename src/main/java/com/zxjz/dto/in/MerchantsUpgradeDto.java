package com.zxjz.dto.in;

public class MerchantsUpgradeDto {
    private int userId;
    private int page;
    private int rows;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "MerchantsUpgradeDto{" +
                "userId=" + userId +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
