package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.UpdatePauseEnum;

public class UpdateRejectExcution extends BaseAPIExcution{

    public UpdateRejectExcution(int updateReject, UpdatePauseEnum updatePauseEnum) {
        this.data = updateReject;
        this.code = updatePauseEnum.getCode();
    }

    public UpdateRejectExcution(String errorInfo, UpdatePauseEnum updatePauseEnum) {
        this.data = errorInfo;
        this.code = updatePauseEnum.getCode();
    }
}
