package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.PendingTreatment;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class PendingTreatmentExcution extends BaseAPIExcution{

    public PendingTreatmentExcution(List<PendingTreatment> pendingTreatmentList, StuPersonalEnum stuPersonalEnum) {
        this.data = pendingTreatmentList;
        this.code = stuPersonalEnum.getCode();
    }

    public PendingTreatmentExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
