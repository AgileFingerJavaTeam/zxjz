package com.zxjz.service.impl;
import com.zxjz.base.BaseException;
import com.zxjz.dao.CollectionInfoDao;
import com.zxjz.dto.excution.CollectionExcution;
import com.zxjz.dto.in.CollectionDto;
import com.zxjz.dto.in.CollectionListDto;
import com.zxjz.entity.ListCollection;
import com.zxjz.enums.CollectionEnum;
import com.zxjz.service.CollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CollectionInfoDao collectionInfoDao;

    public CollectionExcution addConllection(CollectionDto collectionDto) {
        int recruiting_id = collectionDto.getRecruiting_id();
        int student_user_id = collectionDto.getStudent_user_id();
        String collection_time = collectionDto.getCollection_time();
        try {
            int collection = collectionInfoDao.addCollection(recruiting_id, student_user_id, collection_time);
            if (collection <= 0) {
                return new CollectionExcution(CollectionEnum.COLLECTION_NOT_STATE);
            }
            return new CollectionExcution(CollectionEnum.COLLECTION_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CollectionExcution deleteConllection(CollectionDto collectionDto) {
        int recruiting_id = collectionDto.getRecruiting_id();
        int student_user_id = collectionDto.getStudent_user_id();
        try {
            int collection = collectionInfoDao.deleteCollection(recruiting_id, student_user_id);
            if (collection <= 0) {
                return new CollectionExcution(CollectionEnum.DELETE_COLLECTION_NOT_STATE);
            }
                return new CollectionExcution(CollectionEnum.DELETE_COLLECTION_SUCCESS);
        } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new BaseException(e.getMessage());
        }
    }
    public CollectionExcution collectionList(CollectionListDto collectionListDto){
            int user_id = collectionListDto.getUser_id();
        try {
            List<ListCollection> listCollection = collectionInfoDao.collectionList(user_id);
            if (listCollection.size() == 0) {
                return new CollectionExcution(CollectionEnum.FIND_COLLECTIONLIST_NOT_STATE);
            }
                return new CollectionExcution(CollectionEnum.FIND_COLLECTIONLIST_SUCCESS,listCollection);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
