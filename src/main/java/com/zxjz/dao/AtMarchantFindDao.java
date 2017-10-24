package com.zxjz.dao;

import com.zxjz.entity.AtMarchantFind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public interface AtMarchantFindDao {

    public List<AtMarchantFind> getMarchantList(@Param("offset") int offset, @Param("rows") int rows,@Param("at_marchant_search")String at_marchant_search);

    public int findCarouselListCount(@Param("at_marchant_search")String at_marchant_search);

    public AtMarchantFind getMarchantIsLook(@Param("id")int id);

    public int editMarchant(@Param("id")int id);

    public List<AtMarchantFind> getMarchantListTimeSearch(@Param("offset") int offset, @Param("rows") int rows,@Param("at_marchant_search")String at_marchant_search,@Param("start_time")String start_time,@Param("end_time")String end_time);

    public int findCarouselListCount2(@Param("at_marchant_search")String at_marchant_search,@Param("start_time")String start_time,@Param("end_time")String end_time);
}
