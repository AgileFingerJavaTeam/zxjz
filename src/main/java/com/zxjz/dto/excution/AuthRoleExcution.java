package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.AuthRoleEnum;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class AuthRoleExcution extends BaseAPIExcution{

    public AuthRoleExcution(AuthRoleEnum authRoleEnum, Object data) {
        this.code = authRoleEnum.getCode();
        this.data = data;
    }
}
