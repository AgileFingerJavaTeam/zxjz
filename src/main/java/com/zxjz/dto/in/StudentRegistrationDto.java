package com.zxjz.dto.in;

import com.sun.istack.internal.NotNull;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class StudentRegistrationDto {
     @NotNull
      private int work_id;
      private int recruit_id;
      private int user_id;



    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getRecruit_id() {
        return recruit_id;
    }

    public void setRecruit_id(int recruit_id) {
        this.recruit_id = recruit_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "StudentRegistrationDto{" +
                "work_id=" + work_id +
                ", recruit_id=" + recruit_id +
                ", user_id=" + user_id +
                '}';
    }
}
