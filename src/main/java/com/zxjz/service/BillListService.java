package com.zxjz.service;

import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.in.BillListDto;

public interface BillListService {
    /**
     * 获取账单列表
     * @return
     */
    public BillListExcution getBillList(BillListDto billListDto);
}
