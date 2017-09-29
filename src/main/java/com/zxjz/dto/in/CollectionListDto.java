package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class CollectionListDto {

     private int user_id;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "CollectionListDto{" +
                "user_id=" + user_id +
                '}';
    }
}
