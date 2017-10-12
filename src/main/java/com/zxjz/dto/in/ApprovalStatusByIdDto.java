package com.zxjz.dto.in;

public class ApprovalStatusByIdDto {
    private int user_id;
    private String logo_url;
    private String company_name;
    private String industry_involved;
    private String company_address;
    private String longitude;
    private String latitude;
    private String head;
    private String job;
    private String phone;
    private String url;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getIndustry_involved() {
        return industry_involved;
    }

    public void setIndustry_involved(String industry_involved) {
        this.industry_involved = industry_involved;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ApprovalStatusByIdDto{" +
                "user_id=" + user_id +
                ", logo_url='" + logo_url + '\'' +
                ", company_name='" + company_name + '\'' +
                ", industry_involved='" + industry_involved + '\'' +
                ", company_address='" + company_address + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", head='" + head + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
