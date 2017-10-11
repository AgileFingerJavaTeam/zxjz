package com.zxjz.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface HomepageGuaranteeDao {

    public int updateOrDownHomepageGuarantee(@Param("recruiting_id")int recruiting_id,@Param("hzn_good_begin_time")String hzn_good_begin_time,@Param("hzn_good_end_time")String hzn_good_end_time);

    public int updatedownHomepageGuarantee(int recruiting_id);
}
