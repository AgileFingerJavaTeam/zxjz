package com.zxjz.dto.in;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class AtSecurityPositionDto {
      private int releases_user_id;
      private int recruiting_id;
      private String post_name;
      private int post_classification;
      private String work_date;
      private String work_time;
      private String work_location;
      private String position_longitude;
      private String position_latitude;
      private String work_content;
      private double salary_treatment;
      private String commission;
      private String benefits;
      private String gender_requirements;
      private String other_requirements;
      private int recruitment;
      @DateTimeFormat(pattern="yyyy-MM-dd")
      private String hiring_expiration_date;
      private String main_title;
      private String subtitle;
      private String short_description;
      private MultipartFile page_url;
      private MultipartFile first_page_carousel_url;
      private MultipartFile main_page_url;
      private String details_page_introduction;

      private int station_name;



      private String up_down_frame;


    public int getStation_name() {
        return station_name;
    }

    public void setStation_name(int station_name) {
        this.station_name = station_name;
    }

    public String getUp_down_frame() {
        return up_down_frame;
    }

    public void setUp_down_frame(String up_down_frame) {
        this.up_down_frame = up_down_frame;
    }

    public int getReleases_user_id() {
        return releases_user_id;
    }

    public void setReleases_user_id(int releases_user_id) {
        this.releases_user_id = releases_user_id;
    }

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public int getPost_classification() {
        return post_classification;
    }

    public void setPost_classification(int post_classification) {
        this.post_classification = post_classification;
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

    public String getWork_location() {
        return work_location;
    }

    public void setWork_location(String work_location) {
        this.work_location = work_location;
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

    public String getWork_content() {
        return work_content;
    }

    public void setWork_content(String work_content) {
        this.work_content = work_content;
    }

    public double getSalary_treatment() {
        return salary_treatment;
    }

    public void setSalary_treatment(double salary_treatment) {
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

    public String getGender_requirements() {
        return gender_requirements;
    }

    public void setGender_requirements(String gender_requirements) {
        this.gender_requirements = gender_requirements;
    }

    public String getOther_requirements() {
        return other_requirements;
    }

    public void setOther_requirements(String other_requirements) {
        this.other_requirements = other_requirements;
    }

    public int getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(int recruitment) {
        this.recruitment = recruitment;
    }

    public String getHiring_expiration_date() {
        return hiring_expiration_date;
    }

    public void setHiring_expiration_date(String hiring_expiration_date) {
        this.hiring_expiration_date = hiring_expiration_date;
    }

    public String getMain_title() {
        return main_title;
    }

    public void setMain_title(String main_title) {
        this.main_title = main_title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public MultipartFile getPage_url() {
        return page_url;
    }

    public void setPage_url(MultipartFile page_url) {
        this.page_url = page_url;
    }

    public MultipartFile getFirst_page_carousel_url() {
        return first_page_carousel_url;
    }

    public void setFirst_page_carousel_url(MultipartFile first_page_carousel_url) {
        this.first_page_carousel_url = first_page_carousel_url;
    }

    public MultipartFile getMain_page_url() {
        return main_page_url;
    }

    public void setMain_page_url(MultipartFile main_page_url) {
        this.main_page_url = main_page_url;
    }

    public String getDetails_page_introduction() {
        return details_page_introduction;
    }

    public void setDetails_page_introduction(String details_page_introduction) {
        this.details_page_introduction = details_page_introduction;
    }

    @Override
    public String toString() {
        return "AtSecurityPositionDto{" +
                "releases_user_id=" + releases_user_id +
                ", recruiting_id=" + recruiting_id +
                ", post_name='" + post_name + '\'' +
                ", post_classification=" + post_classification +
                ", work_date='" + work_date + '\'' +
                ", work_time='" + work_time + '\'' +
                ", work_location='" + work_location + '\'' +
                ", position_longitude='" + position_longitude + '\'' +
                ", position_latitude='" + position_latitude + '\'' +
                ", work_content='" + work_content + '\'' +
                ", salary_treatment=" + salary_treatment +
                ", commission='" + commission + '\'' +
                ", benefits='" + benefits + '\'' +
                ", gender_requirements='" + gender_requirements + '\'' +
                ", other_requirements='" + other_requirements + '\'' +
                ", recruitment=" + recruitment +
                ", hiring_expiration_date='" + hiring_expiration_date + '\'' +
                ", main_title='" + main_title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", short_description='" + short_description + '\'' +
                ", page_url=" + page_url +
                ", first_page_carousel_url=" + first_page_carousel_url +
                ", main_page_url=" + main_page_url +
                ", details_page_introduction='" + details_page_introduction + '\'' +
                ", station_name='" + station_name + '\'' +
                ", up_down_frame='" + up_down_frame + '\'' +
                '}';
    }
}
