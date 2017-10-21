package com.zxjz.dao;

import com.zxjz.entity.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StationDaoTest {
    @Test
    public void findChildJobInfo1() throws Exception {
    }


    @Autowired
private StationDao stationDao;
    @Test
    public void findParentJobTypeList() throws Exception {
        List<Station> stations = stationDao.findParentJobTypeList(1,20);
        System.out.println("---------");
        System.out.println(stations);
        System.out.println("-----------");
    }
    @Test
    public void updateParentJobState() throws Exception {
        int isdel = stationDao.updateParentJobState(54);
        System.out.println(isdel);
    }
    @Test
    public void findChildJobType() throws Exception {
        List<Station> cstations = stationDao.findChildJobType(1,1,20);
        System.out.println("---------");
        System.out.println(cstations);
        System.out.println("-----------");
    }
    @Test
    public void findChildJobInfo() throws Exception {
        Station ss = stationDao.findChildJobInfo(3);
        System.out.println("---------");
        System.out.println(ss);
        System.out.println("-----------");
    }
    @Test
    public void findParentJobName() throws Exception {
        String ss = stationDao.findParentJobName(1);
        System.out.println("---------");
        System.out.println(ss);
        System.out.println("-----------");
    }
    @Test
    public void findParentJobList() throws Exception {
        List<Station> ss = stationDao.findParentJobList();
        System.out.println("---------");
        System.out.println(ss);
        System.out.println("-----------");
    }

}