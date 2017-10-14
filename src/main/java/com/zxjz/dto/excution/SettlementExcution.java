package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.Settlement;
import com.zxjz.enums.SettlementEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class SettlementExcution extends BaseAPIExcution{
    public SettlementExcution(SettlementEnum settlementEnum,Object data) {
        this.code = settlementEnum.getCode();
        this.data = data;
    }
}
