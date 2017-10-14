package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StuJob;
import com.zxjz.enums.StuJobEnum;

import java.util.List;

public class StuJobExcution extends BaseAPIExcution{

    public StuJobExcution(StuJobEnum stuJobEnum,Object data) {
        this.code = stuJobEnum.getCode();
        this.data=data;
    }
    public StuJobExcution(StuJobEnum stuJobEnum) {
        this.code = stuJobEnum.getCode();


    }

}
