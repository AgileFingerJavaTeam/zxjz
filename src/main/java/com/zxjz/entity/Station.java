package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class Station {
      private int stationId;
      private int pStationId;
      private String stationName;
      private int isDelete;

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

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", pStationId=" + pStationId +
                ", stationName='" + stationName + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
