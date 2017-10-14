package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.ListCollection;
import com.zxjz.enums.CollectionEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class CollectionExcution extends BaseAPIExcution{

    public CollectionExcution(CollectionEnum collectionEnum,Object data) {
        this.code = collectionEnum.getCode();
        this.data = data;
    }
}
