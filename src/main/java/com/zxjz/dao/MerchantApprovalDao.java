package com.zxjz.dao;

import com.zxjz.entity.MerchantApprovalInfo;
import com.zxjz.entity.RecruitmentInfoApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantApprovalDao {
    /*查询商户信息列表*/
    public List<MerchantApprovalInfo> findApprovalList(@Param("hzn_approval_status") String hzn_approval_status,
                                                       @Param("hzn_search_content") String hzn_search_content,
                                                       @Param("sort") String sort,
                                                       @Param("order") String order,
                                                       @Param("offset") int offset,
                                                       @Param("rows") int rows);
    /*查询商户信息数量*/
    public  int findListCount(@Param("hzn_approval_status") String hzn_approval_status,
                              @Param("hzn_search_content") String hzn_search_content);
    /*根据id查看详细信息*/
    public  MerchantApprovalInfo findMerchantByID(int id);


    /*审核商户信息*/
    public int updateRseult(@Param("approval_result")String approval_result,@Param("employees_id") String employees_id, @Param("note") String note,@Param("approval_id") int approval_id);

    /*更新商家账号信息*/
    public int updateMerchantMsg(@Param("company_name")String company_name,@Param("head")String head,@Param("company_address")String company_address,@Param("longitude")String longitude,@Param("latitude") String latitude,@Param("job")String job,@Param("phone") String phone,@Param("url")String url,@Param("user_id")int user_id);

    /*更新商户头像信息*/
    public int updateMerchantPortrait(@Param("logo_url")String logo_url,@Param("user_id")int user_id);

}
