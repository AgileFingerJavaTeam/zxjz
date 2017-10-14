package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StuEvaDetails;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.enums.UpdatePauseEnum;

public class UpdatePauseExcution extends BaseAPIExcution{

    public UpdatePauseExcution(int updatePause, UpdatePauseEnum updatePauseEnum) {
        this.data = updatePause;
        this.code = updatePauseEnum.getCode();
    }

    public UpdatePauseExcution(String errorInfo, UpdatePauseEnum updatePauseEnum) {
        this.data = errorInfo;
        this.code = updatePauseEnum.getCode();
    }

}
