package com.zxjz.entity;

import java.util.List;

public class StationInfo {
    private int station_id;
    private int p_station_id;
    private String station_name;
    private int is_delete;
    private String pstation_name;
    private List<StationInfo> children;

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getP_station_id() {
        return p_station_id;
    }

    public void setP_station_id(int p_station_id) {
        this.p_station_id = p_station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public String getPstation_name() {
        return pstation_name;
    }

    public void setPstation_name(String pstation_name) {
        this.pstation_name = pstation_name;
    }

    public List<StationInfo> getChildren() {
        return children;
    }

    public void setChildren(List<StationInfo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "StationInfo{" +
                "station_id=" + station_id +
                ", p_station_id=" + p_station_id +
                ", station_name='" + station_name + '\'' +
                ", is_delete=" + is_delete +
                ", pstation_name='" + pstation_name + '\'' +
                ", children=" + children +
                '}';
    }
}
