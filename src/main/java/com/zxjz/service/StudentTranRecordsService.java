package com.zxjz.service;

import com.zxjz.dto.excution.StudentTranRecordsExcution;
import com.zxjz.dto.in.StudentTranRecordsDto;

public interface StudentTranRecordsService {
    /**
     * 查学生交易记录
     * @param studentTranRecordsDto
     * @return
     */
    public StudentTranRecordsExcution getStudentTranRecords(StudentTranRecordsDto studentTranRecordsDto);
}
