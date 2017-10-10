package com.zxjz.service;

import com.zxjz.dto.excution.KeywordSearchExcution;
import com.zxjz.dto.in.KeywordSearchDto;

public interface KeywordSearchService {
    /**
     * 关键字查询
     * @return
     */
    public KeywordSearchExcution getKeywordSearch(KeywordSearchDto keywordSearchDto);
}
