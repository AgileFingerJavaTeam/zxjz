package com.zxjz.dto.in;

public class DetailsPageDto {
    private int id;
    private int user_id;
    private int work_id;

    public DetailsPageDto(int id, int user_id, int work_id) {
        this.id = id;
        this.user_id = user_id;
        this.work_id = work_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    @Override
    public String toString() {
        return "DetailsPageDto{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", work_id=" + work_id +
                '}';
    }
}
