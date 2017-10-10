package com.zxjz.dto.excution;

import com.zxjz.entity.JobList;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;
import java.util.Map;

public class JobListExcution {
    private List<JobList> jobList;
    private Map map;
    private int code;
    private String codeInfo;

    public JobListExcution(List<JobList> jobList, StuPersonalEnum stuPersonalEnum) {
        this.jobList = jobList;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public JobListExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
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

    @Override
    public String toString() {
        return "JobListExcution{" +
                "jobList=" + jobList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
