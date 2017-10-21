package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.SystemParameterDao;
import com.zxjz.dto.excution.JobDetailsExcution;
import com.zxjz.dto.excution.MerchantCommentExcution;
import com.zxjz.dto.excution.SystemParameterExcution;
import com.zxjz.dto.in.FindParemeterDto;
import com.zxjz.dto.in.SystemParameterDto;
import com.zxjz.entity.JobDetails;
import com.zxjz.entity.SystemParameter;
import com.zxjz.enums.JobDetailsEnum;
import com.zxjz.enums.MerchantCommentEnum;
import com.zxjz.enums.SystemParameterEnum;
import com.zxjz.exception.FindDatabaseException;
import com.zxjz.exception.FindJobException;
import com.zxjz.exception.db.DeleteInnerErrorException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.SystemParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class SystemParameterServiceImpl implements SystemParameterService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemParameterDao systemParameterDao;

    /**
     * 是否需要更新
     * @param
     * @return
     */
    public SystemParameterExcution isUpdateAPP() {
        String parameter_name = "is_update_app";
        try {
            SystemParameter systemParameter = systemParameterDao.findSystemInfoByParameterName(parameter_name);
            if (systemParameter == null){
                throw new QueryInnerErrorException("未找到该参数");
            }
            return new SystemParameterExcution(SystemParameterEnum.QUERY_SUCCESS,systemParameter);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 商家对学生发表评价
     * @param systemParameterDto
     * @return
     */

    public MerchantCommentExcution evaluateStudent(SystemParameterDto systemParameterDto) {
        int user_id = systemParameterDto.getUser_id();
        int job_id = systemParameterDto.getJob_id();
        int merchant_id = systemParameterDto.getMerchant_id();
        String words_evaluate = systemParameterDto.getWords_evaluate();
        double descriptive_corre = systemParameterDto.getDescriptive_corre();
        double punctuality_idea = systemParameterDto.getPunctuality_idea();
        double conscientiousness = systemParameterDto.getConscientiousness();
        double working_ability = systemParameterDto.getWorking_ability();
        double compre_evaluation = systemParameterDto.getCompre_evaluation();
        try {
            int isAddEvaluate = systemParameterDao.addEvaluate(user_id,job_id,merchant_id,words_evaluate,descriptive_corre,punctuality_idea,conscientiousness,working_ability,compre_evaluation);
            if (isAddEvaluate == 0){
                throw new InsertInnerErrorException("新增评价到学生兼职评价表失败");
            }else{
                int isAddEvaluateInStudentTable = systemParameterDao.addEvaluateInStudentTable(user_id,descriptive_corre,punctuality_idea,conscientiousness,working_ability,compre_evaluation);
                if (isAddEvaluateInStudentTable == 0){
                    throw new InsertInnerErrorException("新增评价到学生信息表失败");
                }
            }
            MerchantCommentExcution merchantCommentExcution = new MerchantCommentExcution(MerchantCommentEnum.EVALUATE_SUCCESS);
            return new MerchantCommentExcution(MerchantCommentEnum.EVALUATE_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询职位详情
     * @param systemParameterDto
     * @return
     */
    @Transactional
    public JobDetailsExcution jobDetails(SystemParameterDto systemParameterDto) {
        int user_id = systemParameterDto.getUser_id();
        int recruiting_id = systemParameterDto.getRecruiting_id();
        try {
            JobDetails jobState = systemParameterDao.findStatusResult(recruiting_id);
            if (jobState == null){
                throw new QueryInnerErrorException("查询职位状态失败");
            }else{
                if ("已通过".equals(jobState)){
                    JobDetails passedJobDetails = systemParameterDao.findPassedJobDetail(user_id,recruiting_id);
                    if (passedJobDetails == null){
                        throw new FindDatabaseException("查询已通过职位信息失败");
                    }
                    return new JobDetailsExcution(JobDetailsEnum.QUERY_JOBDETAILS_SUCCESS,passedJobDetails);
            }else{
                    JobDetails otherJobDetails = systemParameterDao.findOtherJobDetail(user_id,recruiting_id);
                    if (otherJobDetails == null){
                        throw new FindJobException("查询其他状态职位信息失败");
                    }
                    return new JobDetailsExcution(JobDetailsEnum.QUERY_JOBDETAILS_SUCCESS,otherJobDetails);
                }
            }
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (FindDatabaseException e2){
            throw e2;
        }catch (FindJobException e3){
            throw e3;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 显示系统参数时查询系统参数
     * @param findParemeterDto
     * @return
     */
    public SystemParameterExcution findParameterList(FindParemeterDto findParemeterDto) {
        int page = findParemeterDto.getPage();
        int rows = findParemeterDto.getRows();
        int offset = (page - 1) * rows;
        String srt_search_content = findParemeterDto.getSrt_search_content();
        try {
            List<SystemParameter> systemParameterList = systemParameterDao.findSystemPatameter(rows, offset, srt_search_content);
            int systemParameterListCount = systemParameterDao.findSysParameterCount(srt_search_content);
            HashMap map = new HashMap();
            map.put("rows",systemParameterList);
            map.put("total",systemParameterListCount);
            return new SystemParameterExcution(SystemParameterEnum.QUERY_SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 新增一条系统参数
     * @param systemParameterDto
     * @return
     */
    public SystemParameterExcution addSystemParameter(SystemParameterDto systemParameterDto) {
        String serial_number = systemParameterDto.getSerial_number();
        String parameter_name = systemParameterDto.getParameter_name();
        String parameter_description = systemParameterDto.getParameter_description();
        String parameter = systemParameterDto.getParameter();
        try {
            int isAdd = systemParameterDao.addSystemParameter(serial_number,parameter_name,parameter_description,parameter);
            if (isAdd == 0){
                throw new InsertInnerErrorException("新增系统参数失败");
            }
            return new SystemParameterExcution(SystemParameterEnum.ADD_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 显示编辑页面时查询当前参数信息
     * @param systemParameterDto
     * @return
     */
    public SystemParameterExcution findParameterInfoById(SystemParameterDto systemParameterDto) {
        int id = systemParameterDto.getId();
        try {
            SystemParameter systemParameterInfo = systemParameterDao.findSystemParameterInfoById(id);
            return new SystemParameterExcution(SystemParameterEnum.QUERY_SUCCESS,systemParameterInfo);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 编辑一条系统参数
     * @param systemParameterDto
     * @return
     */
    public SystemParameterExcution updateSystemParameter(SystemParameterDto systemParameterDto) {
        int parameter_id = systemParameterDto.getParameter_id();
        String serial_number = systemParameterDto.getSerial_number();
        String parameter_name = systemParameterDto.getParameter_name();
        String parameter_description = systemParameterDto.getParameter_description();
        String parameter = systemParameterDto.getParameter();
        try {
            int isUpdate = systemParameterDao.updateSystemParameter(parameter_id,serial_number,parameter_name,parameter_description,parameter);
            if (isUpdate == 0){
                throw new UpdateInnerErrorException("编辑系统参数失败");
            }
            return new SystemParameterExcution(SystemParameterEnum.EDIT_SUCCESS);
        }catch (UpdateInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 删除一条系统参数
     * @param systemParameterDto
     * @return
     */
    public SystemParameterExcution delSystemParameter(SystemParameterDto systemParameterDto) {
        int parameter_id = systemParameterDto.getParameter_id();
        try {
            int isDel = systemParameterDao.delSystemParameter(parameter_id);
            if (isDel == 0){
                throw new DeleteInnerErrorException("删除一条系统参数失败");
            }
            return new SystemParameterExcution(SystemParameterEnum.DEL_SUCCESS);
        }catch (DeleteInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
