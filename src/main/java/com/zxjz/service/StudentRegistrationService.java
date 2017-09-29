package com.zxjz.service;

import com.zxjz.dto.excution.StudentRegistrationExcution;
import com.zxjz.dto.in.StudentRegistrationDto;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface StudentRegistrationService {

    public StudentRegistrationExcution studentRegistration(StudentRegistrationDto studentRegistrationDto);
}
