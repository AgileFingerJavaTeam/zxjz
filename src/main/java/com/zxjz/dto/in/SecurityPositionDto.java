package com.zxjz.dto.in;


/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class SecurityPositionDto {
    private int p_station_id;
    private int id;
    private int page;
    private int rows;
    private String search;
    private  String statusSearch;




    public int getP_station_id() {
        return p_station_id;
    }

    public void setP_station_id(int p_station_id) {
        this.p_station_id = p_station_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusSearch() {
        return statusSearch;
    }

    public void setStatusSearch(String statusSearch) {
        this.statusSearch = statusSearch;
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
                "p_station_id=" + p_station_id +
                ", id=" + id +
                ", page=" + page +
                ", rows=" + rows +
                ", search='" + search + '\'' +
                ", StatusSearch='" + statusSearch + '\'' +
                '}';
    }
}
