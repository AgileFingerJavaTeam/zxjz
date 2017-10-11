package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class SecurityPositionDto {
    private int id;
    private int page;
    private int rows;
    private String StatusSearch;
    private String search;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusSearch() {
        return StatusSearch;
    }

    public void setStatusSearch(String statusSearch) {
        StatusSearch = statusSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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
        return "SecurityPositionDto{" +
                "id=" + id +
                ", page=" + page +
                ", rows=" + rows +
                ", StatusSearch='" + StatusSearch + '\'' +
                ", search='" + search + '\'' +
                '}';
    }
}
