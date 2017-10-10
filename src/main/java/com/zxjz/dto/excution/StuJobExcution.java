package com.zxjz.dto.excution;


import com.zxjz.entity.StuJob;
import com.zxjz.enums.StuJobEnum;

import java.util.List;

public class StuJobExcution {
    private StuJob stuJob;
    private int code;
    private String codeInfo;
    private List<StuJob> stuJobList;

    public StuJobExcution(StuJobEnum stuJobEnum,StuJob stuJob) {
        this.code = stuJobEnum.getCode();
        this.codeInfo = stuJobEnum.getCodeInfo();
        this.stuJob = stuJob;
    }
    public StuJobExcution(StuJobEnum stuJobEnum) {
        this.code = stuJobEnum.getCode();
        this.codeInfo = stuJobEnum.getCodeInfo();

    }

    public StuJobExcution(StuJobEnum stuJobEnum,List<StuJob> stuJobList) {
        this.code = stuJobEnum.getCode();
        this.codeInfo = stuJobEnum.getCodeInfo();
        this.stuJobList = stuJobList;
    }

    public StuJob getStuJob() {
        return stuJob;
    }

    public void setStuJob(StuJob stuJob) {
        this.stuJob = stuJob;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    public List<StuJob> getStuJobList() {
        return stuJobList;
    }

    public void setStuJobList(List<StuJob> stuJobList) {
        this.stuJobList = stuJobList;
    }

    @Override
    public String toString() {
        return "StuJobExcution{" +
                "stuJob=" + stuJob +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                ", stuJobList=" + stuJobList +
                '}';
    }
}
