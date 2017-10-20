package com.zxjz.dto.in;

public class AuthManagementDto {
    private String permission_grouping_name;
    private int permission_grouping_id;

    public String getPermission_grouping_name() {
        return permission_grouping_name;
    }

    public void setPermission_grouping_name(String permission_grouping_name) {
        this.permission_grouping_name = permission_grouping_name;
    }

    public int getPermission_grouping_id() {
        return permission_grouping_id;
    }

    public void setPermission_grouping_id(int permission_grouping_id) {
        this.permission_grouping_id = permission_grouping_id;
    }

    @Override
    public String toString() {
        return "AuthManagementDto{" +
                "permission_grouping_name='" + permission_grouping_name + '\'' +
                ", permission_grouping_id=" + permission_grouping_id +
                '}';
    }
}
