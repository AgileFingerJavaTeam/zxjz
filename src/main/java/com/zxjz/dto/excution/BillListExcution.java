package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.BillList;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class BillListExcution extends BaseAPIExcution{

    public BillListExcution(List<BillList> billLists, StuPersonalEnum stuPersonalEnum) {
        this.data = billLists;
        this.code = stuPersonalEnum.getCode();
    }

    public BillListExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
