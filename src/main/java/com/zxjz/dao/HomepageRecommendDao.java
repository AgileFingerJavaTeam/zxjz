package com.zxjz.dao;

import com.zxjz.entity.AtCollection;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface HomepageRecommendDao {
    /**
     * 更改首页推荐状态
     * @param recruiting_id
     * @param hzn_recommend_begin_time
     * @param hzn_recommend_end_time
     * @return
     */
     public int updateORHomepageRecommend (@Param("recruiting_id")int recruiting_id,@Param("hzn_recommend_begin_time")String hzn_recommend_begin_time,@Param("hzn_recommend_end_time")String hzn_recommend_end_time);

     public int updateDownHomepageRecommend (int recruiting_id);
}
