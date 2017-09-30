package com.zxjz.service;

import com.zxjz.dto.excution.EnrollJobStatusExcution;
import com.zxjz.dto.excution.QuickSignUpExcution;
import com.zxjz.dto.excution.UpdateJobStatusExcution;
import com.zxjz.dto.in.EnrollJobStatusDto;
import com.zxjz.dto.in.QuickSignUpDto;
import com.zxjz.dto.in.UpdateJobStatusDto;
import com.zxjz.entity.QuickSignUp;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public interface EnrollJobStatusService {

    public EnrollJobStatusExcution findEnrollJobStatus(EnrollJobStatusDto enrollJobStatusDto);

    public UpdateJobStatusExcution updateJobStatus(UpdateJobStatusDto updateJobStatusDto);

    public QuickSignUpExcution quickSignUp(QuickSignUpDto quickSignUpDto);
}
