package com.zxjz.dao;

import com.zxjz.entity.RecruitmentInfoApply;
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
public class ApprovalDaoTest {



    @Autowired
    private ApprovalDao approvalDao;

    /*查询招聘信息列表*/
    @Test
    public void findApprovalList() throws Exception {
        String bxw_approval_status="全部";
        String bxw_search_content=null;
        String sort=null;
        String order=null;
        int  offset=1;
        int rows=5;
        List<RecruitmentInfoApply> findApprovalList=approvalDao.findApprovalList(bxw_approval_status,bxw_search_content,sort,order,offset,rows);
        System.out.println(findApprovalList);
    }
    /*查询招聘信息数量*/
    @Test
    public void findListCount() throws Exception {
        String bxw_approval_status="全部";
        String bxw_search_content=null;
        String sort=null;
        String order=null;
        int findListCount=approvalDao.findListCount(bxw_approval_status,bxw_search_content,sort,order);
        System.out.println(findListCount);
    }
    /*根据id查询详细信息*/
    @Test
    public void findApprovalByID() throws Exception {
        int recruiting_id=1;
        RecruitmentInfoApply findapproval=approvalDao.findApprovalByID(recruiting_id);
        System.out.println(findapproval);
    }
    /*招聘信息审核被拒绝*/
    @Test
    public void updateRefuse() throws Exception {
        int recruiting_id=6;
        int releases_user_id=2;
        int employid=1;
        String dismissed_reason="信誉度不好";
        int refuse=approvalDao.updateRefuse(recruiting_id,releases_user_id,dismissed_reason,employid);
    }

    /*招聘信息审核通过*/
    @Test
    public void updatePass() throws Exception {
        int recruiting_id=6;
        int releases_user_id=2;
        int employid=1;
        int pass=approvalDao.updatePass(recruiting_id,releases_user_id,employid);
        System.out.println(pass);
    }
    /*审核通过添加到正式表*/
    @Test
    public void addMessage() throws Exception {
        int recruiting_id=13;
        int salary_treatment=1;
        int releases_user_id=2;
        String post_name="派发传单";
        int post_classification=2;
        String details_page_category="普通";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_content="打字";
        String settlement_method="周结";
        String commission="无";
        String benefits="包食宿";
        String gender_requirements="女";
        int recruitment=20;
        int people_num=10;
        String hiring_expiration_date="2018-01-01";
        int city=2;
        int addMessaage=approvalDao.addMessage(recruiting_id,salary_treatment,releases_user_id,post_name,post_classification,details_page_category,work_date,work_time,
                                                    work_location,position_longitude,position_latitude,work_content,settlement_method,commission,benefits,gender_requirements,recruitment,people_num,
                                                    hiring_expiration_date,city);
        System.out.println(addMessaage);
    }

}