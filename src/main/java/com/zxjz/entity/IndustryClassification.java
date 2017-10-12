package com.zxjz.entity;

public class IndustryClassification {
    private int value;
    private String text;
    private int isDelete;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "IndustryClassification{" +
                "value=" + value +
                ", text='" + text + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
