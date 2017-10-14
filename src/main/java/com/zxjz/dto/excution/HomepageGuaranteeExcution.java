package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.HomepageGuaranteeEnum;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class HomepageGuaranteeExcution extends BaseAPIExcution{

    public HomepageGuaranteeExcution(HomepageGuaranteeEnum homepageGuaranteeEnum , Object data) {
        this.code = homepageGuaranteeEnum.getCode();
        this.data = data;
    }
}
