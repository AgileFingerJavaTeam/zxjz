package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.base.BaseAPIResult;
import com.zxjz.entity.BillList;
import com.zxjz.enums.ConfirmRejectionEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class ConfirmRejectionExcution extends BaseAPIExcution{

    public ConfirmRejectionExcution(ConfirmRejectionEnum confirmRejectionEnum) {
        this.code = confirmRejectionEnum.getCode();
    }

    public ConfirmRejectionExcution(ConfirmRejectionEnum confirmRejectionEnum, String errorInfo) {
        this.code = confirmRejectionEnum.getCode();
        this.data = errorInfo;
    }

}
