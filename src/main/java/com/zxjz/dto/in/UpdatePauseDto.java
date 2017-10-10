package com.zxjz.dto.in;

public class UpdatePauseDto {
    private int recruitingId;
    private String recruitmentStatus;

    public UpdatePauseDto(int recruitingId, String recruitmentStatus) {
        this.recruitingId = recruitingId;
        this.recruitmentStatus = recruitmentStatus;
    }

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    @Override
    public String toString() {
        return "UpdatePauseDto{" +
                "recruitingId=" + recruitingId +
                ", recruitmentStatus='" + recruitmentStatus + '\'' +
                '}';
    }
}
