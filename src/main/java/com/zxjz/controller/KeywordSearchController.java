package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.KeywordSearchExcution;
import com.zxjz.dto.in.KeywordSearchDto;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.KeywordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/KeywordSearch")
public class KeywordSearchController extends BaseController{
    @Autowired
    private KeywordSearchService keywordSearchService;

    /**
     * 根据关键字查询
     * @param
     * @return
     */
    @RequestMapping(value = "getKeyWord",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getKeyWord(@RequestBody KeywordSearchDto keywordSearchDto){
        //参数验空
        try{
            KeywordSearchExcution keywordSearchExcution = keywordSearchService.getKeywordSearch(keywordSearchDto);
            return new BaseAPIResult(1,keywordSearchExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            KeywordSearchExcution keywordSearchExcution = new KeywordSearchExcution(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,keywordSearchExcution);
        }

    }
}
