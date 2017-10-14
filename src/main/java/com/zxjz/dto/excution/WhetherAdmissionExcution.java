package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class WhetherAdmissionExcution extends BaseAPIExcution{
    public WhetherAdmissionExcution(EnrollJobStatusEnum enrollJobStatusEnum , Object data) {
        this.code = enrollJobStatusEnum.getCode();
        this.data = data;
    }

}
