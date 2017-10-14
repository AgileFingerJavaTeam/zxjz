package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.MerchantCommentEnum;

public class MerchantCommentExcution extends BaseAPIExcution{


    public MerchantCommentExcution(MerchantCommentEnum merchantCommentEnum) {
        this.code = merchantCommentEnum.getCode();
    }
    public MerchantCommentExcution(MerchantCommentEnum merchantCommentEnum,Object data) {
        this.code = merchantCommentEnum.getCode();
        this.data = data;
    }

}
