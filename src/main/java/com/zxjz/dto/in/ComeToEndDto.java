package com.zxjz.dto.in;

public class ComeToEndDto {
    private int work_id;

    public ComeToEndDto(int work_id) {
        this.work_id = work_id;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    @Override
    public String toString() {
        return "ComeToEndDto{" +
                "work_id=" + work_id +
                '}';
    }
}
