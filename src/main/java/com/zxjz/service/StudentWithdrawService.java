package com.zxjz.service;

import com.zxjz.dto.excution.StudentWithdrawExcution;
import com.zxjz.dto.in.StudentWithdrawDto;

public interface StudentWithdrawService {
    /**
     * 查询学生提现列表
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution findStudentWithdrawList(StudentWithdrawDto studentWithdrawDto);

    /**
     * 查询处理的这条学生提现信息
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution findAcceptStudentWithdrawInfo(StudentWithdrawDto studentWithdrawDto);

    /**
     * 更新学生提现信息状态
     * @param studentWithdrawDto
     * @return
     */
    public StudentWithdrawExcution updateStudentWithdrawStatus(StudentWithdrawDto studentWithdrawDto);
}
