package com.zxjz.dao;

import com.zxjz.entity.StudentRegistration;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface StudentRegistrationDao {
     public StudentRegistration findStudentRegistration(@Param("work_id") int work_id, @Param("recruit_id") int recruit_id, @Param("user_id") int user_id);
}
