package com.zxjz.dto.in;

public class StationListDto {
    private int station_id;

    public StationListDto(int station_id) {
        this.station_id = station_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    @Override
    public String toString() {
        return "StationListDto{" +
                "station_id=" + station_id +
                '}';
    }
}
