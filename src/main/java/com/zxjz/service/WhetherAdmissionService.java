package com.zxjz.service;


import com.zxjz.dto.excution.WhetherAdmissionExcution;
import com.zxjz.dto.in.WhetherAdmissionDto;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface WhetherAdmissionService {

    public WhetherAdmissionExcution whetherAdmission(WhetherAdmissionDto whetherAdmissionDto);
}
