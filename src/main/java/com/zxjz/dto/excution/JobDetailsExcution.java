package com.zxjz.dto.excution;

import com.zxjz.entity.JobDetails;
import com.zxjz.enums.JobDetailsEnum;

public class JobDetailsExcution {
    private JobDetails jobDetails;
    private int code;
    private String codeInfo;

    public JobDetailsExcution(JobDetailsEnum jobDetailsEnum) {
        this.code = jobDetailsEnum.getCode();
        this.codeInfo = jobDetailsEnum.getCodeInfo();
    }
    public JobDetailsExcution(JobDetailsEnum jobDetailsEnum,JobDetails jobDetails) {
        this.jobDetails = jobDetails;
        this.code = jobDetailsEnum.getCode();
        this.codeInfo = jobDetailsEnum.getCodeInfo();
    }

    public JobDetails getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(JobDetails jobDetails) {
        this.jobDetails = jobDetails;
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
        return "JobDetailsExcution{" +
                "jobDetails=" + jobDetails +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
