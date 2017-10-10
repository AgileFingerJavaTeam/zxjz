package com.zxjz.dto.in;

public class PendingTreatmentDto {
    private int which;
    private int user_id;

    public PendingTreatmentDto(int which, int user_id) {
        this.which = which;
        this.user_id = user_id;
    }

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PendingTreatmentDto{" +
                "which=" + which +
                ", user_id=" + user_id +
                '}';
    }
}
