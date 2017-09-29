package com.zxjz.service;

import com.zxjz.dto.excution.CollectionExcution;
import com.zxjz.dto.in.CollectionDto;
import com.zxjz.dto.in.CollectionListDto;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public interface CollectionService {

    public CollectionExcution addConllection(CollectionDto collectionDto);

    public CollectionExcution deleteConllection(CollectionDto collectionDto);

    public CollectionExcution collectionList(CollectionListDto collectionListDto);
}
