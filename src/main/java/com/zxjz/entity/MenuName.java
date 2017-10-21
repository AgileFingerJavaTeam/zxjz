package com.zxjz.entity;

public class MenuName {
    private int menuId;
    private String menuName;

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
        return "MenuName{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
