package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.SecurityPositionEnum;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class AtSecurityPositionExcution extends BaseAPIExcution {

    public AtSecurityPositionExcution(SecurityPositionEnum securityPositionEnum,Object data) {
        this.code = securityPositionEnum.getCode();
        this.data = data;
    }
}
