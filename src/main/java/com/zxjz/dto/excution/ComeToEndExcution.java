package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.UpdatePauseEnum;

public class ComeToEndExcution extends BaseAPIExcution{

    public ComeToEndExcution(int updateComeToEnd, UpdatePauseEnum updatePauseEnum) {
        this.data = updateComeToEnd;
        this.code = updatePauseEnum.getCode();
    }

}
