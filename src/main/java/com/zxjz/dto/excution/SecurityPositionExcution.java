package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.AtCollection;
import com.zxjz.enums.SecurityPositionEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class SecurityPositionExcution extends BaseAPIExcution{

    public SecurityPositionExcution(SecurityPositionEnum securityPositionEnum , Object data) {
        this.code = securityPositionEnum.getCode();
        this.data = data;
    }
}
