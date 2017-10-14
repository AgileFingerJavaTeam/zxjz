package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.SystemParameter;
import com.zxjz.enums.SystemParameterEnum;

import java.util.List;

public class SystemParameterExcution extends BaseAPIExcution{

    public SystemParameterExcution(SystemParameterEnum systemParameterEnum) {
        this.code = systemParameterEnum.getCode();
    }
    public SystemParameterExcution(SystemParameterEnum systemParameterEnum,Object data) {
        this.data = data;
        this.code = systemParameterEnum.getCode();
    }
}
