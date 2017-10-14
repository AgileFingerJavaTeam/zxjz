package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.CollectionExcution;
import com.zxjz.dto.in.CollectionDto;
import com.zxjz.dto.in.CollectionListDto;
import com.zxjz.enums.CollectionEnum;
import com.zxjz.exception.db.DeleteInnerErrorException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
@Controller
@RequestMapping("/CollectionApi")
public class CollectionController extends BaseController {
    @Autowired
    private CollectionService collectionService;

    @RequestMapping(value = "/postCollectionState",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CollectionExcution> addConllection(@RequestBody CollectionDto collectionDto) {
        //参数验空
        try {
            CollectionExcution collectionExcution = collectionService.addConllection(collectionDto);
            return new BaseResult<CollectionExcution>(1,collectionExcution);
        } catch (InsertInnerErrorException e) {
             CollectionExcution collectionExcution = new CollectionExcution(CollectionEnum.COLLECTION_NOT_STATE);
            return new BaseResult<CollectionExcution>(0,collectionExcution);
        }
          catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<CollectionExcution>(0,e.getMessage());
        }
    }


    @RequestMapping(value = "/deleteCollection",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CollectionExcution> deleteConllection(@RequestBody CollectionDto collectionDto) {
        //参数验空
        try {
            CollectionExcution collectionExcution = collectionService.deleteConllection(collectionDto);
            return new BaseResult<CollectionExcution>(1,collectionExcution);
        } catch (DeleteInnerErrorException e) {
            CollectionExcution collectionExcution = new CollectionExcution(CollectionEnum.DELETE_COLLECTION_NOT_STATE);
            return new BaseResult<CollectionExcution>(0,collectionExcution);
        }
          catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<CollectionExcution>(0,e.getMessage());
        }
    }

    @RequestMapping(value = "/getCollectionList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<CollectionExcution> findCollectionList(@RequestBody CollectionListDto collectionListDto) {
        //参数验空
        try {
            CollectionExcution collectionExcution = collectionService.collectionList(collectionListDto);
            return new BaseResult<CollectionExcution>(1,collectionExcution);
        }catch (QueryInnerErrorException e) {
            CollectionExcution collectionExcution = new CollectionExcution(CollectionEnum.FIND_COLLECTIONLIST_NOT_STATE);
            return new BaseResult<CollectionExcution>(0,collectionExcution);
        }
         catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new BaseResult<CollectionExcution>(0,e.getMessage());
        }
    }
}
