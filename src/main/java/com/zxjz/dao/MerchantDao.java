package com.zxjz.dao;

import com.zxjz.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public interface MerchantDao {
    /**
     * 查精品
     * @param recruiting_id
     * @return
     */
     public GuaranteePositionInfo findBoutique(int recruiting_id);

    /**
     * 查是否已报名
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
     public RegistrationInfo findReinfo(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);

    /**
     * 查是否已收藏
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
     public InformationCollectionInfo findMainfo(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);

    /**
     * 查商家信息
     * @param recruiting_id
     * @return
     */
     public RecruitmentInfo findGuaRec(int recruiting_id);

     public GetMerchantInfo findMerchantInformation(int user_id);

}
