package com.zxjz.service;

import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.in.CheckBillDto;

public interface CheckBillService {
    public CheckBillExcution findBills(CheckBillDto checkBillDto);
}
