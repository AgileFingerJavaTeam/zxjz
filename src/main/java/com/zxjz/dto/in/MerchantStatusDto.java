package com.zxjz.dto.in;

import com.sun.istack.internal.NotNull;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class MerchantStatusDto {
   @NotNull
    private int user_id;
   @NotNull
    private String which;



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getWhich() {
        return which;
    }

    public void setWhich(String which) {
        this.which = which;
    }

    @Override
    public String toString() {
        return "MerchantStatusDto{" +
                "user_id=" + user_id +
                ", which='" + which + '\'' +
                '}';
    }
}
