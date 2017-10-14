package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.JobList;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;
import java.util.Map;

public class JobListExcution extends BaseAPIExcution{

    public JobListExcution(List<JobList> jobList, StuPersonalEnum stuPersonalEnum) {
        this.data = jobList;
        this.code = stuPersonalEnum.getCode();
    }

    public JobListExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
