package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantStatusOne;
import com.zxjz.entity.MerchantStatusThree;
import com.zxjz.entity.MerchantStatusTwo;
import com.zxjz.enums.MerchantStatusEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class MerchantStatusExcution extends BaseAPIExcution{

    public MerchantStatusExcution(MerchantStatusEnum merchantStatusEnum , Object data) {
        this.code = merchantStatusEnum.getCode();
        this.data = data;
    }


}
