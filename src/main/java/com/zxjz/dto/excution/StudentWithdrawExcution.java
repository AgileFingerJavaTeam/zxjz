package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StudentWithdraw;
import com.zxjz.enums.StudentWithdrawEnum;

import java.util.List;

public class StudentWithdrawExcution extends BaseAPIExcution {
    public StudentWithdrawExcution(StudentWithdrawEnum studentWithdrawEnum,Object data) {
        this.code = studentWithdrawEnum.getCode();
        this.data = data;
    }
    public StudentWithdrawExcution(StudentWithdrawEnum studentWithdrawEnum) {
        this.code = studentWithdrawEnum.getCode();
    }
}
