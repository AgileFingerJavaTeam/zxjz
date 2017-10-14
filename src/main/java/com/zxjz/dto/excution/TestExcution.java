package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.TestEnum;

/**
 * Created by sunzhongyuan on 2017/10/12.
 */
public class TestExcution extends BaseAPIExcution{

    public TestExcution(TestEnum testEnum,Object data) {
        this.code = testEnum.getCode();
        this.data = data;
    }

}
