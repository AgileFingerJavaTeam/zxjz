package com.zxjz.service;

import com.zxjz.dto.excution.JobListExcution;
import com.zxjz.dto.excution.StationListExcution;
import com.zxjz.dto.in.JobListDto;

public interface StationListService {
    /**
     * 获取职位类型
     * @return
     */
    public StationListExcution getStationList();

    /**
     * 根据条件获取职位列表
     * @return
     */
    public JobListExcution getJobList(JobListDto jobListDto);
}
