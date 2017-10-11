package com.zxjz.dao;

import com.zxjz.entity.AtCollection;
import com.zxjz.entity.MerchantAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public interface SecurityPositionDao  {
    /**
     * 显示数据
     * @param offset
     * @param rows
     * @return
     */
    public List<AtCollection> findListCollection(@Param("offset")int offset , @Param("rows")int rows);

    /**
     * 后台显示总数
     * @param StatusSearch
     * @param search
     * @return
     */
    public int findSecurityPositionListCount(@Param("StatusSearch")String StatusSearch,@Param("search")String search);

    /**
     * 详情
     * @param id
     * @return
     */
    public AtCollection findSecurityPositionSecurity (int id);

    /**
     * 详情list 通过ID查name 岗位分类
     * @param post_calssification
     * @return
     */
    public Map findSecurityPositionSecurity1(int post_calssification);

    /**
     * 添加框查看 遍历商户名称
     * @return
     */
    public List<MerchantAccount> findListMarchantName ();
}
