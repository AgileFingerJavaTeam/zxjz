package com.zxjz.dao;

import com.zxjz.entity.MarchantArrear;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public interface MarchantArrearDao {
    /**
     * 查数据
     * @param at_search
     * @param offset
     * @param rows
     * @return
     */
    public List<MarchantArrear> findMarchantArrear(@Param("at_search")String at_search,@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 模糊查询
     * @param at_search
     * @param offset
     * @param rows
     * @return
     */
    public List<MarchantArrear> findMarchantArrearSearch(@Param("at_search")String at_search,@Param("offset")int offset,@Param("rows")int rows);
    /**
     * 模糊查询查看页
     * @param at_searchs
     * @param offset
     * @param rows
     * @return
     */
    public List<MarchantArrear> getReceivablesListSearch(@Param("at_searchs")String at_searchs,@Param("offset")int offset,@Param("rows")int rows,@Param("userId")int userId);
    /**
     * 显示总数
     * @param at_search
     * @return
     */
    public int findCarouselListCount(@Param("at_search")String at_search);
    /**
     * 欠款商户数量
     * @param
     * @return
     */
    public int findCarouselListCount3();

    /**
     * 欠款总金额
     * @return
     */
    public MarchantArrear findCarouselListCount4();
    /**
     * 当前授信商户数量
     * @return
     */
    public int findCarouselListCount5();
    /**
     * 当前授信商户授信总金额
     * @return
     */
    public MarchantArrear findCarouselListCount6();
    /**
     * 显示总数
     * @param at_searchs
     * @return
     */
    public int findCarouselListCount2(@Param("at_searchs")String at_searchs,@Param("userId")int userId);

    /**
     * 显示总数
     * @param at_searchs
     * @return
     */
    public int findCarouselListCountU(@Param("at_searchs")String at_searchs,@Param("userId")int userId);
    /**
     * 跳转查看页上
     * @param userId
     * @return
     */
    public MarchantArrear findSecurity(@Param("userId")int userId);
    /**
     * 跳转查看页下
     * @param at_searchs
     * @param offset
     * @param rows
     * @param userId
     * @return
     */
    public List<MarchantArrear> getReceivablesList(@Param("at_searchs")String at_searchs,@Param("offset")int offset,@Param("rows")int rows,@Param("userId")int userId);
}
