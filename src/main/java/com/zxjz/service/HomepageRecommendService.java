package com.zxjz.service;

import com.zxjz.dto.excution.HomepageRecommendExcution;
import com.zxjz.dto.in.HomepageRecommendDto;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface HomepageRecommendService {

    public HomepageRecommendExcution updateOrHomepageRecommend(HomepageRecommendDto homepageRecommendDto);

    public HomepageRecommendExcution updateCloseHomepageRecommend(HomepageRecommendDto homepageRecommendDto);
}
