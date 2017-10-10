package com.zxjz.dao;

import com.zxjz.entity.KeywordSearch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordSearchDao {
    /**
     * 关键字查询
     * @param key_word
     * @return
     */
    public List<KeywordSearch> getKeywordSearch(@Param("key_word") String key_word);
}
