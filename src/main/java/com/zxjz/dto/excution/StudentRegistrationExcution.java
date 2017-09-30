package com.zxjz.dto.excution;

import com.zxjz.entity.StudentRegistration;
import com.zxjz.enums.EnrollJobStatusEnum;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class StudentRegistrationExcution {
     private StudentRegistration studentRegistration;
     private int code;
     private String codeInfo;

    public StudentRegistrationExcution(EnrollJobStatusEnum enrollJobStatusEnum,StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
    }

    public StudentRegistrationExcution(EnrollJobStatusEnum enrollJobStatusEnum) {
        this.code = enrollJobStatusEnum.getCode();
        this.codeInfo = enrollJobStatusEnum.getCodeInfo();
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "StudentRegistrationExcution{" +
                "studentRegistration=" + studentRegistration +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
