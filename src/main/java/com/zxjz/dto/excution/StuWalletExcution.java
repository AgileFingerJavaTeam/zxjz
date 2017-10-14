package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.base.BaseException;
import com.zxjz.entity.StuWallletBase;
import com.zxjz.enums.StuWalletEnum;


public class StuWalletExcution  extends BaseAPIExcution{


    public StuWalletExcution( StuWalletEnum stuWalletEnum) {
        this.code=stuWalletEnum.getCode();

    }
    public StuWalletExcution( StuWalletEnum stuWalletEnum,Object data) {
        this.code=stuWalletEnum.getCode();
        this.data=data;
    }


}
