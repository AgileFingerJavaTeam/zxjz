package com.zxjz.entity;

public class ConfirmRejection {
    private String recruitment;//招聘人数
    private String employedNumber;//已经录用人数

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    public String getEmployedNumber() {
        return employedNumber;
    }

    public void setEmployedNumber(String employedNumber) {
        this.employedNumber = employedNumber;
    }

    @Override
    public String toString() {
        return "ConfirmRejection{" +
                "recruitment='" + recruitment + '\'' +
                ", employedNumber='" + employedNumber + '\'' +
                '}';
    }
}
