package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.HomepageRecommendEnum;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class HomepageRecommendExcution extends BaseAPIExcution{

    public HomepageRecommendExcution(HomepageRecommendEnum homepageRecommendEnum,Object data) {
        this.code = homepageRecommendEnum.getCode();
        this.data = data;
    }
}
