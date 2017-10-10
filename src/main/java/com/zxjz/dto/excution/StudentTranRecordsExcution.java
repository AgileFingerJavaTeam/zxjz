package com.zxjz.dto.excution;

import com.zxjz.entity.StudentTranRecords;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class StudentTranRecordsExcution {
    private List<StudentTranRecords> StudentTranRecordsList;
    private int code;
    private String codeInfo;

    public StudentTranRecordsExcution(List<StudentTranRecords> StudentTranRecordsList, CityEnum cityEnum) {
        this.StudentTranRecordsList = StudentTranRecordsList;
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public StudentTranRecordsExcution(CityEnum cityEnum) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public List<StudentTranRecords> getStudentTranRecordsList() {
        return StudentTranRecordsList;
    }

    public void setStudentTranRecordsList(List<StudentTranRecords> studentTranRecordsList) {
        StudentTranRecordsList = studentTranRecordsList;
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
        return "StudentTranRecordsExcution{" +
                "StudentTranRecordsList=" + StudentTranRecordsList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
