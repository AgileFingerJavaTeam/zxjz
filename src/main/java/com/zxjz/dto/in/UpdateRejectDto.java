package com.zxjz.dto.in;

public class UpdateRejectDto {
    private int recruitingId;

    public UpdateRejectDto(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    @Override
    public String toString() {
        return "UpdateRejectDto{" +
                "recruitingId=" + recruitingId +
                '}';
    }
}
