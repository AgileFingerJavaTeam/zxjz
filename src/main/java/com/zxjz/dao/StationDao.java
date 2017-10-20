package com.zxjz.dao;

import com.zxjz.dto.in.StationDto;
import com.zxjz.entity.Station;
import com.zxjz.entity.StationInfo;
import com.zxjz.util.PageData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationDao {
    /**
     * 查询父类职位类型列表
     * @param
     * @return
     */
    public List<Station> findParentJobTypeList(@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 获取父类职位条数
     * @return
     */
    public int findParentJobCount ();

    /**
     * 新增父类职位类型
     * @param station_name
     * @return
     */
    public int addParentJobType (@Param("station_name")String station_name);

    /**
     * 查询父类职位信息
     * @param id
     * @return
     */
    public Station findParentJobInfo(@Param("id") int id);

    /**
     * 更新父类职位信息
     * @param station_name
     * @return
     */
    public int editParentJobInfo (@Param("station_name")String station_name,@Param("station_id")int station_id);

    /**
     * 查询此父类职位的子类条数
     * @param station_id
     * @return
     */
    public int findCount(@Param("station_id")int station_id);

    /**
     * 更新父类职位类型状态（标记删除）
     * @param station_id
     * @return
     */
    public int updateParentJobState(@Param("station_id")int station_id);

    /**
     * 查询子类岗位类型
     * @param pstationId
     * @param offset
     * @param rows
     * @return
     */
    public List<Station> findChildJobType (@Param("pstationId")int pstationId,@Param("offset")int offset,@Param("rows")int rows);

    /**
     * 查询子类岗位条数
     * @param pstationId
     * @return
     */
    public int findChildJobCount (@Param("pstationId")int pstationId);

    /**
     * 查询父类职位信息
     * @return
     */
    public List<Station> findParentJobList();

    /**
     * 新增子类岗位类型
     * @param p_station_id
     * @param station_name
     * @return
     */
    public int addChildJobType (@Param("p_station_id")int p_station_id,@Param("station_name")String station_name);

    /**
     * 查询子类岗位信息
     * @param id
     * @return
     */
    public Station findChildJobInfo (@Param("id")int id);

    /**
     * 查询此子类岗位的父级职位名称
     * @param p_station_id
     * @return
     */
    public String findParentJobName(@Param("p_station_id")int p_station_id);

    /**
     * 更新子类岗位状态（标记删除）
     * @param station_id
     * @return
     */
    public int updateChildJobState (@Param("station_id")int station_id);

    /**
     * 编辑子类岗位信息
     * @param station_name
     * @param pstation_id
     * @param station_id
     * @return
     */
    public int editChildJobInfo(@Param("station_name")String station_name,@Param("pstation_id")int pstation_id,@Param("station_id")int station_id);
}
