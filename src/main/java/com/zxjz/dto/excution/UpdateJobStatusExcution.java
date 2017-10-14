package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class UpdateJobStatusExcution extends BaseAPIExcution{
    public UpdateJobStatusExcution(EnrollJobStatusEnum enrollJobStatusEnum,Object data) {
        this.code = enrollJobStatusEnum.getCode();
        this.data = data;
    }

}
