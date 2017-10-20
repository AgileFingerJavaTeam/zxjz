package com.zxjz.dao;

import com.zxjz.entity.AtCarouselManage;
import com.zxjz.entity.CarouselInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public interface CarouselManageDao {
    /**
     * 显示页面
     * @param xzf_search_content
     * @param offset
     * @param rows
     * @return
     */
     public List<CarouselInfo> findCarouselListAll(@Param("xzf_search_content")String xzf_search_content,@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 查总数
     * @param xzf_search_content
     * @return
     */
     public int findCarouselListCount(@Param("xzf_search_content")String xzf_search_content);

    /**
     * 添加
     * @param map
     * @return
     */
     public int insertCarousel(Map map);

    /**
     * 查商户名
     * @return
     */
     public List<AtCarouselManage> findTitle();

    /**
     * 查编辑页面数据
     * @return
     */
     public CarouselInfo findCarouseObject(@Param("carousel_figure_id")int carousel_figure_id);

    /**
     * 编辑
     * @param map
     * @return
     */
     public int updateCarousel(Map map);

    /**
     * 编辑图片
     * @param map
     * @return
     */
     public int updateCarousel2(Map map);

    /**
     * 编辑状态
     * @param state
     * @param carousel_figure_id
     * @return
     */
     public int updateChangeCarousel(@Param("state")String state,@Param("carousel_figure_id")int carousel_figure_id);

    /**
     * 删除信息
     * @param carousel_figure_id
     * @return
     */
     public int deleteCarousel(@Param("carousel_figure_id")int carousel_figure_id);


}
