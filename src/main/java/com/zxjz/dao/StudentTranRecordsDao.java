package com.zxjz.dao;

import com.zxjz.entity.StudentTranRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTranRecordsDao {
    /**
     * 学生交易记录
     * @return
     */
    public List<StudentTranRecords> getStudentTranRecordsList(@Param("merchant_user_id") int merchant_user_id,
                                                              @Param("college_user_id") int college_user_id);
}
