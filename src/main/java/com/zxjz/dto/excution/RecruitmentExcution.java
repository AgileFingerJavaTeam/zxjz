package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.CheckBill;
import com.zxjz.entity.MerchantFundsCurrentAccount;
import com.zxjz.enums.RecruitmentEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecruitmentExcution extends BaseAPIExcution {


    public RecruitmentExcution(RecruitmentEnum recruitmentEnum,Object data) {

        this.code = recruitmentEnum.getCode();
        this.data = data;
    }


    public RecruitmentExcution(RecruitmentEnum recruitmentEnum) {
        this.code = recruitmentEnum.getCode();

    }


}
