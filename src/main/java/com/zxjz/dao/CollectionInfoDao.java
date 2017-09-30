package com.zxjz.dao;

import com.zxjz.entity.ListCollection;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/**
 * Created by Antong on 2017/9/22 0022.
 */
public interface CollectionInfoDao {
    /**
     * 添加收藏状态
     * @param recruiting_id
     * @param student_user_id
     * @param collection_time
     * @return
     */
     public int addCollection(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id, @Param("collection_time") String collection_time);

    /**
     * 删除收藏状态
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
     public int deleteCollection(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);

    /**
     * 通过用户ID查集合
     * @param user_id
     * @return
     */
     public List<ListCollection> collectionList(int user_id);
}
