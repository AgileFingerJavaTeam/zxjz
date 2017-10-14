package com.zxjz.dto.in;

import com.sun.istack.internal.NotNull;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecruitmentDto {
    @NotNull
    private int user_id;
    @NotNull
    private String post_name;
    @NotNull
    private String settlement_method;
    @NotNull
    private int salary_treatment;
    @NotNull
    private String commission;
    @NotNull
    private String benefits;
    @NotNull
    private String position_longitude;
    @NotNull
    private String position_latitude;
    @NotNull
    private String work_location;
    @NotNull
    private String work_date;
    @NotNull
    private String work_time;
    @NotNull
    private int recruitment;
    @NotNull
    private String gender_requirements;
    @NotNull
    private String work_content;
    @NotNull
    private String hiring_expiration_date;
    @NotNull
    private String leader;

    private  String status_time;

    private String leader_phone;
    @NotNull
    private int post_classification;
    @NotNull
    private int city;
    private  int recruiting_id;
    private String status_result;
    private String dismissed_reason;
    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getSettlement_method() {
        return settlement_method;
    }

    public void setSettlement_method(String settlement_method) {
        this.settlement_method = settlement_method;
    }

    public int getSalary_treatment() {
        return salary_treatment;
    }

    public void setSalary_treatment(int salary_treatment) {
        this.salary_treatment = salary_treatment;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getPosition_longitude() {
        return position_longitude;
    }

    public void setPosition_longitude(String position_longitude) {
        this.position_longitude = position_longitude;
    }

    public String getPosition_latitude() {
        return position_latitude;
    }

    public void setPosition_latitude(String position_latitude) {
        this.position_latitude = position_latitude;
    }

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }

    public String getWork_date() {
        return work_date;
    }

    public void setWork_date(String work_date) {
        this.work_date = work_date;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public int getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(int recruitment) {
        this.recruitment = recruitment;
    }

    public String getGender_requirements() {
        return gender_requirements;
    }

    public void setGender_requirements(String gender_requirements) {
        this.gender_requirements = gender_requirements;
    }

    public String getWork_content() {
        return work_content;
    }

    public void setWork_content(String work_content) {
        this.work_content = work_content;
    }

    public String getHiring_expiration_date() {
        return hiring_expiration_date;
    }

    public void setHiring_expiration_date(String hiring_expiration_date) {
        this.hiring_expiration_date = hiring_expiration_date;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeader_phone() {
        return leader_phone;
    }

    public void setLeader_phone(String leader_phone) {
        this.leader_phone = leader_phone;
    }

    public int getPost_classification() {
        return post_classification;
    }

    public void setPost_classification(int post_classification) {
        this.post_classification = post_classification;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getStatus_time() {
        return status_time;
    }

    public void setStatus_time(String status_time) {
        this.status_time = status_time;
    }

    public String getStatus_result() {
        return status_result;
    }

    public void setStatus_result(String status_result) {
        this.status_result = status_result;
    }

    public String getDismissed_reason() {
        return dismissed_reason;
    }

    public void setDismissed_reason(String dismissed_reason) {
        this.dismissed_reason = dismissed_reason;
    }

    @Override
    public String toString() {
        return "RecruitmentDto{" +
                "user_id=" + user_id +
                ", post_name='" + post_name + '\'' +
                ", settlement_method='" + settlement_method + '\'' +
                ", salary_treatment=" + salary_treatment +
                ", commission='" + commission + '\'' +
                ", benefits='" + benefits + '\'' +
                ", position_longitude='" + position_longitude + '\'' +
                ", position_latitude='" + position_latitude + '\'' +
                ", work_location='" + work_location + '\'' +
                ", work_date='" + work_date + '\'' +
                ", work_time='" + work_time + '\'' +
                ", recruitment=" + recruitment +
                ", gender_requirements='" + gender_requirements + '\'' +
                ", work_content='" + work_content + '\'' +
                ", hiring_expiration_date='" + hiring_expiration_date + '\'' +
                ", leader='" + leader + '\'' +
                ", status_time='" + status_time + '\'' +
                ", leader_phone='" + leader_phone + '\'' +
                ", post_classification=" + post_classification +
                ", city=" + city +
                ", recruiting_id=" + recruiting_id +
                ", status_result='" + status_result + '\'' +
                ", dismissed_reason='" + dismissed_reason + '\'' +
                '}';
    }
}
