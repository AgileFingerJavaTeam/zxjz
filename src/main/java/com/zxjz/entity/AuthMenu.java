package com.zxjz.entity;

public class AuthMenu {
    private int permissionGroupingId;//权限分组ID
    private int authoritySerialNumber;//权限序号
    private int menuId;//菜单ID

    public int getPermissionGroupingId() {
        return permissionGroupingId;
    }

    public void setPermissionGroupingId(int permissionGroupingId) {
        this.permissionGroupingId = permissionGroupingId;
    }

    public int getAuthoritySerialNumber() {
        return authoritySerialNumber;
    }

    public void setAuthoritySerialNumber(int authoritySerialNumber) {
        this.authoritySerialNumber = authoritySerialNumber;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "AuthMenu{" +
                "permissionGroupingId=" + permissionGroupingId +
                ", authoritySerialNumber=" + authoritySerialNumber +
                ", menuId=" + menuId +
                '}';
    }
}
