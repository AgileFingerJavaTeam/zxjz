package com.zxjz.dao;

import com.zxjz.entity.StuJob;
import com.zxjz.entity.StuMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMsgDao {

public List<StuMsg> findStuMsg(@Param("offset")int offset,
                               @Param("rows")int rows,
                               @Param("bxw_search_content")String bxw_search_content);

public int findMsgNum(@Param("bxw_search_content")String bxw_search_content);


public int updateStatus(int user_id);
}
