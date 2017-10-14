package com.zxjz.dao;

import com.zxjz.entity.AtCollection;
import com.zxjz.entity.MerchantAccount;
import com.zxjz.entity.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

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
     * 显示数据 担保/首页
     * @param offset
     * @param rows
     * @return
     */
    public List<AtCollection> findListCollection2(@Param("offset")int offset , @Param("rows")int rows);

    /**
     * 后台显示总数
     * @param statusSearch
     * @param search
     * @return
     */
    public int findSecurityPositionListCount(@Param("statusSearch")String statusSearch,@Param("search")String search);

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

    /**
     * 添加框查看 遍历岗位分类
     * @return
     */
    public List<Station>findListStation();

    /**
     * 添加框查看 遍历二级岗位分类
     * @param p_station_id
     * @return
     */
    public List<Station> findListTwoLevelStation(@Param("p_station_id") int p_station_id);

    /**
     * 添加精品职位数据
     * @return
     */
    public int addSecurityPosition(Map map);

    /**
     * 添加精品职位数据
     * @return
     */
    public int addSecurityPosition2(Map map);
    /**
     * 获取精品主键最大值
     * @return
     */
    public String getSecurityIndex();

    /**
     * 编辑系统参数页面
     * @param parentPostClassification
     * @return
     */
    public int findParentPostClassification(int parentPostClassification);

    /**
     * 编辑精品职位数据
     * @param map
     * @return
     */
    public int SecurityPositionUpdate(Map map);
    /**
     * 编辑精品职位数据
     * @param map
     * @return
     */
    public int SecurityPositionUpdate2(Map map);
    /**
     * 编辑精品职位数据
     * @param map
     * @return
     */
    public int SecurityPositionUpdate3(Map map);
    /**
     * 编辑精品职位数据
     * @param map
     * @return
     */
    public int SecurityPositionUpdate4(Map map);

    /**
     * 模糊查询
     * @param offset
     * @param rows
     * @param search
     * @return
     */
    public List<AtCollection> findSearch(@Param("offset")int offset , @Param("rows")int rows,@Param("search")String search);

    /**
     * 状态筛选
     * @param offset
     * @param rows
     * @param statusSearch
     * @return
     */
    public List<AtCollection> findStatusSearch(@Param("offset")int offset , @Param("rows")int rows,@Param("statusSearch")String statusSearch);
    /**
     * 否上首页推荐/担保 状态筛选
     * @param offset
     * @param rows
     * @param StatusSearch
     * @return
     */
    public List<AtCollection> findStatusSearch2(@Param("offset")int offset , @Param("rows")int rows,@Param("statusSearch")String statusSearch);
}
