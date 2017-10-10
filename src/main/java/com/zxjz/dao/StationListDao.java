package com.zxjz.dao;

import com.zxjz.entity.JobList;
import com.zxjz.entity.StationList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StationListDao {
    /**
     * 获取父级岗位分类
     */
    public List<StationList> getStationList();

    /**
     * 获取子级岗位分类
     */
    public List<StationList> getchildrenStationList(int station_id);

    /**
     * 根据条件获取职位列表
     * @return
     */
    public List<JobList> getJobList(@Param("select_type") int select_type,
                                    @Param("sex") String sex,
                                    @Param("sex_str") String sex_str,
                                    @Param("star_job") String star_job,
                                    @Param("city_type") String city_type,
                                    @Param("job_type") String job_type,
                                    @Param("payment_type") String payment_type,
                                    @Param("payment_type_str") String payment_type_str,
                                    @Param("order_type") String order_type);
}
