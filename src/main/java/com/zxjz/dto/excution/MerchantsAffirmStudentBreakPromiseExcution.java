package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.MerchantsAffirmStudentBreakPromiseEnum;

public class MerchantsAffirmStudentBreakPromiseExcution extends BaseAPIExcution{

    public MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum merchantsAffirmStudentBreakPromiseEnum) {
        this.code = merchantsAffirmStudentBreakPromiseEnum.getCode();
    }
    public MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum merchantsAffirmStudentBreakPromiseEnum,Object data) {
        this.code = merchantsAffirmStudentBreakPromiseEnum.getCode();
        this.data = data;
    }
}
