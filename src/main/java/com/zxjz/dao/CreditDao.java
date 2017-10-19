package com.zxjz.dao;

import com.zxjz.entity.CreditAndPayment;
import com.zxjz.entity.RecruitmentInfoApply;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface CreditDao {
    /*获取信息列表*/
    public ArrayList<CreditAndPayment> findCreditList(@Param("bxw_search_content")String bxw_search_content,
                                                      @Param("sort")String sort,
                                                      @Param("order")String order,
                                                      @Param("offset")int offset,
                                                      @Param("rows")int rows);
    /*获取信息列表数量*/
    public int total( @Param("sort")String sort, @Param("order")String order);
    /*显示授信与账期*/
    public  CreditAndPayment updateCredit(int user_id);
    /*提交授信*/
    public int submitCredit(@Param("user_id")int user_id,@Param("credit_total")double credit_total);
    /*提交账期*/
    public int submitPayment(@Param("user_id")int user_id,@Param("payment_days")String payment_days);
}
