package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.StuJobEnum;
import com.zxjz.enums.StuMsgEnum;

public class StuMsgExcution extends BaseAPIExcution{

    public StuMsgExcution(StuMsgEnum stuMsgEnum, Object data) {
        this.code = stuMsgEnum.getCode();
        this.data=data;
    }
    public StuMsgExcution(StuMsgEnum stuMsgEnum) {
        this.code = stuMsgEnum.getCode();
    }

}
