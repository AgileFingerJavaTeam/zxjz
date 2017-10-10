package com.zxjz.dto.in;

public class StudentTranRecordsDto {
    private int merchant_user_id;
    private int college_user_id;

    public StudentTranRecordsDto(int merchant_user_id, int college_user_id) {
        this.merchant_user_id = merchant_user_id;
        this.college_user_id = college_user_id;
    }

    public int getMerchant_user_id() {
        return merchant_user_id;
    }

    public void setMerchant_user_id(int merchant_user_id) {
        this.merchant_user_id = merchant_user_id;
    }

    public int getCollege_user_id() {
        return college_user_id;
    }

    public void setCollege_user_id(int college_user_id) {
        this.college_user_id = college_user_id;
    }

    @Override
    public String toString() {
        return "StudentTranRecordsDto{" +
                "merchant_user_id=" + merchant_user_id +
                ", college_user_id=" + college_user_id +
                '}';
    }
}
