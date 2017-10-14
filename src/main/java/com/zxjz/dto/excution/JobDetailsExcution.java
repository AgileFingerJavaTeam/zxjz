package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.JobDetails;
import com.zxjz.enums.JobDetailsEnum;

public class JobDetailsExcution extends BaseAPIExcution{

    public JobDetailsExcution(JobDetailsEnum jobDetailsEnum) {
        this.code = jobDetailsEnum.getCode();
    }
    public JobDetailsExcution(JobDetailsEnum jobDetailsEnum,Object data) {
        this.code = jobDetailsEnum.getCode();
        this.data = data;
    }

}
