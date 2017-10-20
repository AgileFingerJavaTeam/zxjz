package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StationDao;
import com.zxjz.dto.excution.StationInfoExcution;
import com.zxjz.dto.in.StationDto;
import com.zxjz.entity.Station;
import com.zxjz.enums.StationInfoEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.StationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StationInfoServiceImpl implements StationInfoService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StationDao stationDao;

    /**
     * 查询父类岗位列表
     * @param stationDto
     * @return
     */
    public StationInfoExcution findParentJobList(StationDto stationDto) {
        int page = stationDto.getPage();
        int rows = stationDto.getRows();
        int offset=(page-1)*rows;
        try {
            List<Station> stationInfoList = stationDao.findParentJobTypeList(offset,rows);
            if (stationInfoList == null){
                throw new QueryInnerErrorException("查询父类职位列表失败");
            }
            int parentJobCount = stationDao.findParentJobCount();
            HashMap map = new HashMap();
            map.put("rows",stationInfoList);
            map.put("total",parentJobCount);
            return new StationInfoExcution(StationInfoEnum.FIND_SUCCESS,map);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 新增父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution addParentJobType(StationDto stationDto) {
        String station_name = stationDto.getStation_name();
        try {
            int addParentJobType = stationDao.addParentJobType(station_name);
            if (addParentJobType == 0){
                throw new InsertInnerErrorException("新增父类岗位类型失败");
            }
            return new StationInfoExcution(StationInfoEnum.ADD_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询父类岗位信息
     * @param stationDto
     * @return
     */
    public StationInfoExcution findParentJobInfo(StationDto stationDto) {
        int id = stationDto.getId();
        try {
            Station parentJobInfo = stationDao.findParentJobInfo(id);
            if (parentJobInfo == null){
                throw new QueryInnerErrorException("查询父类岗位类型信息失败");
            }
            return new StationInfoExcution(StationInfoEnum.FIND_SUCCESS,parentJobInfo);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 编辑父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution editParentJobInfo(StationDto stationDto) {
        String station_name = stationDto.getStation_name();
        int station_id = stationDto.getStation_id();
        try {
            int editParentJobInfo = stationDao.editParentJobInfo(station_name,station_id);
            if (editParentJobInfo == 0){
                throw new UpdateInnerErrorException("更新父类岗位信息失败（编辑父类岗位失败）");
            }
            return new StationInfoExcution(StationInfoEnum.EDIT_PARENT_JOB_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 删除父类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution deleteParentJobType(StationDto stationDto) {
        int station_id = stationDto.getStation_id();
        try {
            int childCount = stationDao.findCount(station_id);
            if (childCount != 0){
                throw  new QueryInnerErrorException("该父类下面有子类不能删除");
            }
            int isDelete = stationDao.updateParentJobState(station_id);
            if (isDelete == 0){
                throw new UpdateInnerErrorException("更新父类岗位状态失败（删除父类失败）");
            }
            return new StationInfoExcution(StationInfoEnum.DELETE_PARENT_JOB_SUCCESS);
        }catch (QueryInnerErrorException e2){
            throw e2;
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询子类岗位列表
     * @param stationDto
     * @return
     */
    public StationInfoExcution findChildJobList(StationDto stationDto) {
        int pstationId = stationDto.getPstationId();
        String pstationName = stationDto.getPstationName();
        int page = stationDto.getPage();
        int rows = stationDto.getRows();
        int offset=(page-1)*rows;
        try {
            List<Station> stationInfoList = stationDao.findChildJobType(pstationId,offset,rows);
            int childCount = stationDao.findChildJobCount(pstationId);
            HashMap map = new HashMap();
            map.put("rows",stationInfoList);
            map.put("total",childCount);
            return new StationInfoExcution(StationInfoEnum.FIND_CHILD_INFO_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询父类信息
     * @return
     */
    public StationInfoExcution findParentJob(StationDto stationDto) {
        try {
            List<Station> pageDataList = stationDao.findParentJobList();
            if (pageDataList == null){
                throw new QueryInnerErrorException("查询父类信息失败");
            }
            return new StationInfoExcution(StationInfoEnum.FIND_SUCCESS,pageDataList);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 添加子类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution addChildJobType(StationDto stationDto) {
        int p_station_id = stationDto.getP_station_id();
        String station_name = stationDto.getStation_name();
        try {
            int isAdd = stationDao.addChildJobType(p_station_id,station_name);
            if (isAdd == 0){
                throw new InsertInnerErrorException("新增子类岗位类型失败");
            }
            return new StationInfoExcution(StationInfoEnum.ADD_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询子类岗位信息及父类岗位名称
     * @param stationDto
     * @return
     */
    public StationInfoExcution findChildJobInfo(StationDto stationDto) {
        int id = stationDto.getId();
        try {
            Station childJobInfo = stationDao.findChildJobInfo(id);
            if (childJobInfo == null){
                throw new QueryInnerErrorException("查询子类岗位信息失败");
            }
            int p_station_id = childJobInfo.getpStationId();
            String parentJobName = stationDao.findParentJobName(p_station_id);
            if (parentJobName == null){
                throw new QueryInnerErrorException("查询父类岗位名称失败");
            }
            HashMap map = new HashMap();
            map.put("childJobInfo",childJobInfo);
            map.put("parentJobName",parentJobName);
            return new StationInfoExcution(StationInfoEnum.FIND_SUCCESS,map);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 编辑子类岗位类型
     * @param stationDto
     * @return
     */
    public StationInfoExcution editChildJobType(StationDto stationDto) {
        String station_name = stationDto.getStation_name();
        int pstation_id = stationDto.getPstationId();
        int station_id = stationDto.getStation_id();
        try {
            int isEdit = stationDao.editChildJobInfo(station_name,pstation_id,station_id);
            if (isEdit == 0){
                throw new UpdateInnerErrorException("编辑子类岗位失败");
            }
            return new StationInfoExcution(StationInfoEnum.FIND_CHILD_INFO_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public StationInfoExcution delectChildJobType(StationDto stationDto) {
        int station_id = stationDto.getStation_id();
        try {
            int isDelect = stationDao.updateChildJobState(station_id);
            if (isDelect == 0){
                throw new UpdateInnerErrorException("更新子类岗位状态失败");
            }
            return new StationInfoExcution(StationInfoEnum.DELETE_CHILD_JOB_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
