package com.zxjz.dto.in;

public class ConfirmRejectionDto {
    private String hired;
    private int recruiting_id;
    private int id;

    public ConfirmRejectionDto(String hired, int recruiting_id, int id) {
        this.hired = hired;
        this.recruiting_id = recruiting_id;
        this.id = id;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    @Override
    public String toString() {
        return "ConfirmRejectionDto{" +
                "hired='" + hired + '\'' +
                ", recruiting_id=" + recruiting_id +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
