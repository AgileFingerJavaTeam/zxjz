package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StuEvaDetails;
import com.zxjz.enums.StuPersonalEnum;

public class StuEvaDetailsExcution extends BaseAPIExcution{

    public StuEvaDetailsExcution(StuEvaDetails stuEvaDetails, StuPersonalEnum stuPersonalEnum) {
        this.data = stuEvaDetails;
        this.code = stuPersonalEnum.getCode();
    }

    public StuEvaDetailsExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
