package com.zxjz.dto.in;

public class IndustryClassificationDto {
    private String name;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IndustryClassificationDto{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
