package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.KeywordSearchDao;
import com.zxjz.dto.excution.KeywordSearchExcution;
import com.zxjz.dto.in.KeywordSearchDto;
import com.zxjz.entity.KeywordSearch;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.KeywordSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordSearchServiceImpl implements KeywordSearchService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public KeywordSearchDao keywordSearchDao;


    public KeywordSearchExcution getKeywordSearch(KeywordSearchDto keywordSearchDto) {
        String key_word = keywordSearchDto.getKey_word();
        try {
            List<KeywordSearch> keywordSearcheList = keywordSearchDao.getKeywordSearch(key_word);
            return new KeywordSearchExcution(keywordSearcheList, StuPersonalEnum.FIND_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
