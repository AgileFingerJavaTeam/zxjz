package com.zxjz.dao;

import com.zxjz.entity.StuJob;
import com.zxjz.entity.StuMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMsgDao {

public List<StuMsg> findStuMsg(@Param("offset")int offset,
                               @Param("rows")int rows,
                               @Param("bxw_search_content")String bxw_search_content,
                               @Param("start")String start,
                               @Param("end")String end);

public int findMsgNum(@Param("bxw_search_content")String bxw_search_content,
                      @Param("start")String start,
                      @Param("end")String end);


public int updateStatus(int user_id);
}
