package com.zxjz.service;

import com.zxjz.dto.excution.CheckStudentsExcution;
import com.zxjz.dto.in.CheckStudentsDto;
import com.zxjz.entity.CheckStudentsInfo;

import java.util.List;

public interface CheckStudentsService {
    /**
     * 查询审核学生列表
     * @param checkStudentsDto
     * @return
     */
    public CheckStudentsExcution findStudentsInfoList (CheckStudentsDto checkStudentsDto);

    /**
     * 查询当前审核的学生信息
     * @param checkStudentsDto
     * @return
     */
    public CheckStudentsExcution findStudentsInfoById (CheckStudentsDto checkStudentsDto);

    /**
     * 提交审核
     * @param checkStudentsDto
     * @return
     */
    public CheckStudentsExcution submitAudit(CheckStudentsDto checkStudentsDto);
}
