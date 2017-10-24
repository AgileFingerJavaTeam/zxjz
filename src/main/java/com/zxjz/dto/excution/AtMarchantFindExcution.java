package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.AtMarchantFindEnum;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class AtMarchantFindExcution extends BaseAPIExcution{

    public AtMarchantFindExcution(AtMarchantFindEnum atMarchantFindEnum,Object data) {
        this.code = atMarchantFindEnum.getCode();
        this.data = data ;
    }
}
