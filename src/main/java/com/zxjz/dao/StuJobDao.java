package com.zxjz.dao;

import com.zxjz.entity.StuJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuJobDao {

public StuJob findJob(int userid);

public List<StuJob> findjoblist(@Param("userid") int userid, @Param("type") int type);


}
