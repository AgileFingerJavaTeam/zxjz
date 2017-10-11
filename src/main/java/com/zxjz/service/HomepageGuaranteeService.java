package com.zxjz.service;

import com.zxjz.dto.excution.HomepageGuaranteeExcution;
import com.zxjz.dto.in.HomepageGuaranteeDto;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface HomepageGuaranteeService {

    public HomepageGuaranteeExcution updateOrDownHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto);

    public HomepageGuaranteeExcution updatedownHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto);
}
