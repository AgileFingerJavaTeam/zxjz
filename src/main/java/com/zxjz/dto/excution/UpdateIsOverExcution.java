package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.UpdatePauseEnum;

public class UpdateIsOverExcution extends BaseAPIExcution{

    public UpdateIsOverExcution(int updateIsOver, UpdatePauseEnum updatePauseEnum) {
        this.data = updateIsOver;
        this.code = updatePauseEnum.getCode();
    }

    public UpdateIsOverExcution(String errorInfo, UpdatePauseEnum updatePauseEnum) {
        this.data = errorInfo;
        this.code = updatePauseEnum.getCode();
    }

}
