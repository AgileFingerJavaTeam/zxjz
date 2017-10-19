package com.zxjz.entity;

public class AuthManagement {
    private int permissionGroupingId;//权限分组ID
    private String permissionGroupingName;//权限分组名称
    private int menuId;//菜单ID
    private String menuName;//菜单名称

    public int getPermissionGroupingId() {
        return permissionGroupingId;
    }

    public void setPermissionGroupingId(int permissionGroupingId) {
        this.permissionGroupingId = permissionGroupingId;
    }

    public String getPermissionGroupingName() {
        return permissionGroupingName;
    }

    public void setPermissionGroupingName(String permissionGroupingName) {
        this.permissionGroupingName = permissionGroupingName;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "AuthManagement{" +
                "permissionGroupingId=" + permissionGroupingId +
                ", permissionGroupingName='" + permissionGroupingName + '\'' +
                ", menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
