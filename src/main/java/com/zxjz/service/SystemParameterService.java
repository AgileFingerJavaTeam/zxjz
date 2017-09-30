package com.zxjz.service;

import com.zxjz.dto.excution.JobDetailsExcution;
import com.zxjz.dto.excution.MerchantCommentExcution;
import com.zxjz.dto.excution.SystemParameterExcution;
import com.zxjz.dto.in.SystemParameterDto;

public interface SystemParameterService {
    /**
     * 是否更新APP
     * @param
     * @return
     */
    public SystemParameterExcution isUpdateAPP();

    /**
     * 发表评价
     * @param systemParameterDto
     * @return
     */
    public MerchantCommentExcution evaluateStudent(SystemParameterDto systemParameterDto);

    /**
     * 查询职位详情
     * @param systemParameterDto
     * @return
     */
    public JobDetailsExcution jobDetails(SystemParameterDto systemParameterDto);
}
