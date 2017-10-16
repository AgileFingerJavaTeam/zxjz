package com.zxjz.dto.in;

import com.sun.istack.internal.NotNull;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class AuthRoleDto {
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthRoleDto{" +
                "id=" + id +
                '}';
    }
}
