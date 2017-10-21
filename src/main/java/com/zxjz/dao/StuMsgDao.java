package com.zxjz.dao;

import com.zxjz.entity.StuJob;
import com.zxjz.entity.StuMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMsgDao {

public List<StuMsg> findStuMsg(@Param("offset")int offset,
                               @Param("rows")int rows);

public int findMsgNum();


public int updateStatus(int user_id);
}
