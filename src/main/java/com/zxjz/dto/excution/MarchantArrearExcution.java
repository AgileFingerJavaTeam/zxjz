package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.MarchantArrearEnum;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class MarchantArrearExcution extends BaseAPIExcution{
    public MarchantArrearExcution(MarchantArrearEnum marchantArrearEnum,Object data) {
        this.code = marchantArrearEnum.getCode();
        this.data = data;
    }
}
