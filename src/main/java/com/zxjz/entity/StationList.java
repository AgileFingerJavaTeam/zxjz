package com.zxjz.entity;

import java.util.List;

public class StationList {
    private int stationId;
    private int pStationId;
    private String stationName;
    private int isDelete;
    private String pstationName;
    private List<StationList> children;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getpStationId() {
        return pStationId;
    }

    public void setpStationId(int pStationId) {
        this.pStationId = pStationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getPstationName() {
        return pstationName;
    }

    public void setPstationName(String pstationName) {
        this.pstationName = pstationName;
    }

    public List<StationList> getChildren() {
        return children;
    }

    public void setChildren(List<StationList> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "StationList{" +
                "stationId=" + stationId +
                ", pStationId=" + pStationId +
                ", stationName='" + stationName + '\'' +
                ", isDelete=" + isDelete +
                ", pstationName='" + pstationName + '\'' +
                ", children=" + children +
                '}';
    }
}
