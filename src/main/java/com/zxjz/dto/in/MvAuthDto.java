package com.zxjz.dto.in;

public class MvAuthDto {
    private int permission_grouping_id;
    private String permission_grouping_name;
    private String hidden_menu_id;

    public String getPermission_grouping_name() {
        return permission_grouping_name;
    }

    public void setPermission_grouping_name(String permission_grouping_name) {
        this.permission_grouping_name = permission_grouping_name;
    }

    public String getHidden_menu_id() {
        return hidden_menu_id;
    }

    public void setHidden_menu_id(String hidden_menu_id) {
        this.hidden_menu_id = hidden_menu_id;
    }

    public int getPermission_grouping_id() {
        return permission_grouping_id;
    }

    public void setPermission_grouping_id(int permission_grouping_id) {
        this.permission_grouping_id = permission_grouping_id;
    }

    @Override
    public String toString() {
        return "MvAuthDto{" +
                "permission_grouping_id=" + permission_grouping_id +
                ", permission_grouping_name='" + permission_grouping_name + '\'' +
                ", hidden_menu_id='" + hidden_menu_id + '\'' +
                '}';
    }
}
