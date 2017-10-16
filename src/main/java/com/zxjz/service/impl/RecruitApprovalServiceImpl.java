package com.zxjz.service.impl;


import com.zxjz.base.BaseException;
import com.zxjz.dao.ApprovalDao;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.in.RecruitApprovalDto;
import com.zxjz.entity.RecruitmentInfoApply;
import com.zxjz.enums.RecruitApprovalEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.RecruitApprovalService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class RecruitApprovalServiceImpl implements RecruitApprovalService {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApprovalDao approvalDao;
    public RecruitApprovalExcution findApprovalList(RecruitApprovalDto recruitApprovalDto) {
        String bxw_approval_status=recruitApprovalDto.getBxw_approval_status();
        String bxw_search_content=recruitApprovalDto.getBxw_search_content();
        String sort=recruitApprovalDto.getSort();
        String  order=recruitApprovalDto.getOrder();

        int rows=recruitApprovalDto.getRows();
        int page=recruitApprovalDto.getPage();
        try{
            int offset = (page - 1) * rows;
            List<RecruitmentInfoApply> approvalList =approvalDao.findApprovalList(bxw_approval_status,bxw_search_content,sort,order,offset,rows);
            if(approvalList!=null){
                for (RecruitmentInfoApply mer : approvalList) {
                    String applyTime = mer.getApplyTime();
                    String statusTime = mer.getStatusTime();
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if (applyTime != null) {
                        Date datea = fmt.parse(applyTime);
                        String apply = fmt.format(datea);
                        mer.setApplyTime(apply);
                    }
                    if (statusTime != null) {
                        Date dates = fmt.parse(statusTime);
                        String status = fmt.format(dates);
                        mer.setStatusTime(status);
                    }

                }
                int total=approvalDao.findListCount(bxw_approval_status,bxw_search_content,order,sort);
                HashMap map=new HashMap();
                map.put("approvalList",approvalList);
                map.put("total",total);
                return  new RecruitApprovalExcution(RecruitApprovalEnum.FIND_SUCCESS,map);
            }else {
                throw   new QueryInnerErrorException("查询失败");
            }
        }catch (QueryInnerErrorException  q) {
            throw q;
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }

    }

    /*public RecruitApprovalExcution findTotal(RecruitApprovalDto recruitApprovalDto) {
        String bxw_approval_status=recruitApprovalDto.getBxw_approval_status();
        String bxw_search_content=recruitApprovalDto.getBxw_search_content();
        String sort=recruitApprovalDto.getSort();
        String  order=recruitApprovalDto.getOrder();
        try{
            int total=approvalDao.findListCount(bxw_approval_status,bxw_search_content,order,sort);
            if(total>0){
                return  new RecruitApprovalExcution(RecruitApprovalEnum.FIND_SUCCESS,total);
            }else{
                throw   new QueryInnerErrorException("查询失败");
            }
        }catch (QueryInnerErrorException  q) {
            throw q;
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }*/

    public RecruitApprovalExcution findApprovalByID(RecruitApprovalDto recruitApprovalDto) {
        int recruiting_id=recruitApprovalDto.getRecruiting_id();


        try{
            RecruitmentInfoApply findApprovalByID=approvalDao.findApprovalByID(recruiting_id);
            if(findApprovalByID!=null){
                String applyTime = findApprovalByID.getApplyTime();
                String statusTime = findApprovalByID.getStatusTime();
                String hirTime = findApprovalByID.getHiringExpirationDate();
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (applyTime != null) {
                    Date datea = fmt.parse(applyTime);
                    String apply = fmt.format(datea);
                    findApprovalByID.setApplyTime(apply);
                }
                if (statusTime != null) {
                    Date dates = fmt.parse(statusTime);
                    String status = fmt.format(dates);
                    findApprovalByID.setStatusTime(status);
                }
                if (hirTime != null) {
                    Date dateh = fmt.parse(hirTime);
                    String hire = fmt.format(dateh);
                    findApprovalByID.setHiringExpirationDate(hire);
                }
                return  new RecruitApprovalExcution(RecruitApprovalEnum.FIND_SUCCESS,findApprovalByID);
            }else {
                throw new QueryInnerErrorException("查询失败");
            }
        }catch (QueryInnerErrorException  q) {
            throw q;
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    public RecruitApprovalExcution updateRefuse(RecruitApprovalDto recruitApprovalDto) {
        int recruiting_id=recruitApprovalDto.getRecruiting_id();
        int releases_user_id=recruitApprovalDto.getReleases_user_id();
        String dismissed_reason=recruitApprovalDto.getDismissed_reason();
        int employid=recruitApprovalDto.getEmployid();
        String result=recruitApprovalDto.getResult();
        int salary_treatment=recruitApprovalDto.getSalary_treatment();
        String post_name=recruitApprovalDto.getPost_name();
        int post_classification=recruitApprovalDto.getPost_classification();
        String details_page_category=recruitApprovalDto.getDetails_page_category();
        String work_date=recruitApprovalDto.getWork_date();
        String work_time=recruitApprovalDto.getWork_time();
        String work_location=recruitApprovalDto.getWork_location();
        String position_longitude=recruitApprovalDto.getPosition_longitude();
        String position_latitude=recruitApprovalDto.getPosition_latitude();
        String work_content=recruitApprovalDto.getWork_content();
        String settlement_method=recruitApprovalDto.getSettlement_method();
        String commission=recruitApprovalDto.getCommission();
        String benefits=recruitApprovalDto.getBenefits();
        String gender_requirements=recruitApprovalDto.getGender_requirements();
        int recruitment=recruitApprovalDto.getRecruitment();
        int people_num=recruitApprovalDto.getPeople_num();
        String hiring_expiration_date=recruitApprovalDto.getHiring_expiration_date();
        int city=recruitApprovalDto.getCity();
        if(result.equals("1")){
            int updateRefuse=approvalDao.updateRefuse(recruiting_id,releases_user_id,dismissed_reason,employid);
            if(updateRefuse>0){
                return  new RecruitApprovalExcution(RecruitApprovalEnum.UP_SUCCESS,null);
            }else{
                throw new UnsupportedOperationException("更改失败");
            }
        }else{
            int updatePass=approvalDao.updatePass(recruiting_id,releases_user_id,employid);
            if(updatePass>0){
                int addMessage=approvalDao.addMessage(recruiting_id,salary_treatment,releases_user_id,post_name,post_classification,details_page_category,work_date,work_time,work_location,position_longitude,position_latitude,work_content,settlement_method,commission,benefits,gender_requirements,recruitment,people_num,hiring_expiration_date,city);
                if(addMessage>0){
                    return  new RecruitApprovalExcution(RecruitApprovalEnum.ADD_SUCCESS,null);
                }else{
                    throw new UnsupportedOperationException("添加失败");
                }
            }else{
                throw new UnsupportedOperationException("更改失败");
            }
        }

    }

    public RecruitApprovalExcution updatePass(RecruitApprovalDto recruitApprovalDto) {
        return null;
    }

    public RecruitApprovalExcution addMessage(RecruitApprovalDto recruitApprovalDto) {
        return null;
    }
}
