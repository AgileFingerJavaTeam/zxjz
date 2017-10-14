package com.zxjz.service;

import com.zxjz.dto.excution.StationInfoExcution;
import com.zxjz.dto.in.StationDto;

public interface StationInfoService {
    /**
     * 查询父类岗位信息
     * @param stationDto
     * @return
     */
    public StationInfoExcution findParentJobList (StationDto stationDto);

    /**
     * 新增父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution addParentJobType (StationDto stationDto);

    /**
     * 查询父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution findParentJobInfo (StationDto stationDto);

    /**
     * 编辑父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution editParentJobInfo (StationDto stationDto);

    /**
     * 删除父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution deleteParentJobType(StationDto stationDto);

    /**
     * 查询子类岗位列表
     * @param stationDto
     * @return
     */
    public StationInfoExcution findChildJobList(StationDto stationDto);

    /**
     * 查询父类信息
     * @param stationDto
     * @return
     */
    public StationInfoExcution findParentJob(StationDto stationDto);

    /**
     * 添加子类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution addChildJobType(StationDto stationDto);

    /**
     * 查询子类岗位信息
     * @param stationDto
     * @return
     */
    public StationInfoExcution findChildJobInfo(StationDto stationDto);

    /**
     * 编辑子类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution editChildJobType(StationDto stationDto);

    /**
     * 删除子类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution delectChildJobType(StationDto stationDto);
}
