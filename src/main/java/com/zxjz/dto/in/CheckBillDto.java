package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class CheckBillDto {

     private int student_user_id;
     private int user_id;
     private int page;
     private int rows;
     private int references_the_internal_serial_number1;
     private int work_id;
     private int recruitId;
     private String q;
     private String reference_bill_classification;
     private String merchants_name;

    public String getReference_bill_classification() {
        return reference_bill_classification;
    }

    public void setReference_bill_classification(String reference_bill_classification) {
        this.reference_bill_classification = reference_bill_classification;
    }

    public String getMerchants_name() {
        return merchants_name;
    }

    public void setMerchants_name(String merchants_name) {
        this.merchants_name = merchants_name;
    }

    public int getReferences_the_internal_serial_number1() {
        return references_the_internal_serial_number1;
    }

    public void setReferences_the_internal_serial_number1(int references_the_internal_serial_number1) {
        this.references_the_internal_serial_number1 = references_the_internal_serial_number1;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getStudent_user_id() {
        return student_user_id;
    }

    public void setStudent_user_id(int student_user_id) {
        this.student_user_id = student_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "CheckBillDto{" +
                "student_user_id=" + student_user_id +
                ", user_id=" + user_id +
                ", page=" + page +
                ", rows=" + rows +
                ", references_the_internal_serial_number1=" + references_the_internal_serial_number1 +
                ", work_id=" + work_id +
                ", recruitId=" + recruitId +
                ", q='" + q + '\'' +
                ", reference_bill_classification='" + reference_bill_classification + '\'' +
                ", merchants_name='" + merchants_name + '\'' +
                '}';
    }
}
