package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StudentTranRecords;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class StudentTranRecordsExcution extends BaseAPIExcution{

    public StudentTranRecordsExcution(List<StudentTranRecords> StudentTranRecordsList, CityEnum cityEnum) {
        this.data = StudentTranRecordsList;
        this.code = cityEnum.getCode();
    }

    public StudentTranRecordsExcution(String errorInfo, CityEnum cityEnum) {
        this.data = errorInfo;
        this.code = cityEnum.getCode();
    }

}
