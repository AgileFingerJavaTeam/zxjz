package com.zxjz.service;

import com.zxjz.dto.excution.ManagementPartExcuton;
import com.zxjz.dto.excution.UpdateIsOverExcution;
import com.zxjz.dto.excution.UpdatePauseExcution;
import com.zxjz.dto.excution.UpdateRejectExcution;
import com.zxjz.dto.in.ManagementPartDto;
import com.zxjz.dto.in.UpdatePauseDto;
import com.zxjz.dto.in.UpdateRejectDto;

public interface ManagementPartService {
    /**
     * 获取职位管理
     */
    public ManagementPartExcuton findManagementPart(ManagementPartDto managementPartDto);

    /**
     * 修改暂停
     */
    public UpdatePauseExcution updatePause(UpdatePauseDto updatePauseDto);

    /**
     * 修改已驳回
     */
    public UpdateRejectExcution updateReject(UpdateRejectDto updateRejectDto);

    /**
     * 修改结束
     */
    public UpdateIsOverExcution updateIsOver(UpdateRejectDto updateRejectDto);
}
