package com.zxjz.entity;

public class EmployeeRightsInfo {
    private int permissionGroupingId;//权限分组ID
    private String permissionGroupingName;//权限分组名称
    private int menuId;//菜单ID
    private String menuName;//菜单名称
    private String menuEntryUrl;//菜单入口URL

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

    public String getMenuEntryUrl() {
        return menuEntryUrl;
    }

    public void setMenuEntryUrl(String menuEntryUrl) {
        this.menuEntryUrl = menuEntryUrl;
    }

    @Override
    public String toString() {
        return "EmployeeRightsInfo{" +
                "permissionGroupingId=" + permissionGroupingId +
                ", permissionGroupingName='" + permissionGroupingName + '\'' +
                ", menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuEntryUrl='" + menuEntryUrl + '\'' +
                '}';
    }
}
