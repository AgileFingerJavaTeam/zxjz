package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StuPersonal;
import com.zxjz.enums.StuPersonalEnum;

public class StuPersonalExcution extends BaseAPIExcution{

    public StuPersonalExcution(StuPersonal stuPersonal, StuPersonalEnum stuPersonalEnum) {
        this.data = stuPersonal;
        this.code = stuPersonalEnum.getCode();
    }

    public StuPersonalExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
