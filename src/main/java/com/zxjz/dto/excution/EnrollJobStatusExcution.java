package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.EnrollJobStatus;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class EnrollJobStatusExcution extends BaseAPIExcution {
    public EnrollJobStatusExcution(EnrollJobStatusEnum enrollJobStatusEnum , Object data) {
        this.code = enrollJobStatusEnum.getCode();
        this.data = data;
    }
}
