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
}
