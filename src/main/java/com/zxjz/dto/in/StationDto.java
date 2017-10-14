package com.zxjz.dto.in;

public class StationDto {
    private int page;
    private int rows;
    private String station_name;
    private int id;
    private int station_id;
    private int pstationName;
    private int p_station_id;
    private String pid;
    private String pname;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getPstationName() {
        return pstationName;
    }

    public void setPstationName(int pstationName) {
        this.pstationName = pstationName;
    }

    public int getP_station_id() {
        return p_station_id;
    }

    public void setP_station_id(int p_station_id) {
        this.p_station_id = p_station_id;
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "page=" + page +
                ", rows=" + rows +
                ", station_name='" + station_name + '\'' +
                ", id=" + id +
                ", station_id=" + station_id +
                ", pstationName=" + pstationName +
                ", p_station_id=" + p_station_id +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
