package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class AtMarchantFindDto {
     private int userId;
     private int id;
     private int page;
     private int rows;
     private String isLook;

     private String start_time;
     private String end_time;

     private String at_marchant_search;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getIsLook() {
        return isLook;
    }

    public void setIsLook(String isLook) {
        this.isLook = isLook;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAt_marchant_search() {
        return at_marchant_search;
    }

    public void setAt_marchant_search(String at_marchant_search) {
        this.at_marchant_search = at_marchant_search;
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

    @Override
    public String toString() {
        return "AtMarchantFindDto{" +
                "userId=" + userId +
                ", id=" + id +
                ", page=" + page +
                ", rows=" + rows +
                ", isLook='" + isLook + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", at_marchant_search='" + at_marchant_search + '\'' +
                '}';
    }
}
