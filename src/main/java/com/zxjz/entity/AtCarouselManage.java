package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class AtCarouselManage {
          private int recruitingId;
          private String postName;
          private String companyName;

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "AtCarouselManage{" +
                "recruitingId=" + recruitingId +
                ", postName='" + postName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
