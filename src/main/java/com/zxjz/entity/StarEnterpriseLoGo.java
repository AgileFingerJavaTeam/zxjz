package com.zxjz.entity;

public class StarEnterpriseLoGo {
    private int iconId;
    private String pictureUrl;

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "StarEnterpriseLoGo{" +
                "iconId=" + iconId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
