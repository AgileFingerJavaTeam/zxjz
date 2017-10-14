package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.GetMerchantInfo;
import com.zxjz.entity.GuaranteePositionInfo;
import com.zxjz.entity.InformationCollectionInfo;
import com.zxjz.entity.RegistrationInfo;
import com.zxjz.enums.MerchantEnum;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class MerchantExcution extends BaseAPIExcution{

    public MerchantExcution(MerchantEnum merchantEnum, Map<String, Object> map) {
        this.data = map;
        this.code = merchantEnum.getCode();
    }

    public MerchantExcution(MerchantEnum merchantEnum, String errorInfo) {
        this.data = errorInfo;
        this.code = merchantEnum.getCode();
    }

}
