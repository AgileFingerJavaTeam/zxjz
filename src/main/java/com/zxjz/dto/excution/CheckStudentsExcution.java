package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CheckStudentsEnum;


public class CheckStudentsExcution extends BaseAPIExcution{

    public CheckStudentsExcution(CheckStudentsEnum checkStudentsEnum,Object data ) {
        this.code = checkStudentsEnum.getCode();
        this.data = data;
    }
    public CheckStudentsExcution(CheckStudentsEnum checkStudentsEnum ) {
        this.code = checkStudentsEnum.getCode();
    }

}
