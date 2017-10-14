package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.ManagementPart;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class ManagementPartExcuton extends BaseAPIExcution{

    public ManagementPartExcuton(List<ManagementPart> managementPart, StuPersonalEnum stuPersonalEnum) {
        this.data = managementPart;
        this.code = stuPersonalEnum.getCode();
    }

    public ManagementPartExcuton(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }
    public ManagementPartExcuton(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
    }

}
