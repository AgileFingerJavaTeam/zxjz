package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.StudentSetBoundPhoneEnum;

public class StudentSetBoundPhoneExcution extends BaseAPIExcution{

    public StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum studentSetBoundPhoneEnum) {
        this.code = studentSetBoundPhoneEnum.getCode();
    }
    public StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum studentSetBoundPhoneEnum,Object data) {
        this.data = data;
        this.code = studentSetBoundPhoneEnum.getCode();
    }

}
