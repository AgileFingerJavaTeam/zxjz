package com.zxjz.service.impl;


import com.zxjz.base.BaseException;
import com.zxjz.dao.MerchantApprovalDao;
import com.zxjz.dto.excution.MerchantApprovalExcution;
import com.zxjz.dto.in.MerchantApprovalDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.entity.MerchantApprovalInfo;
import com.zxjz.enums.MerchantApprovalEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.MerchantApprovalService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class MerchantApprovalServiceImpl implements MerchantApprovalService {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchantApprovalDao merchantApprovalDao;
    /*查询信息列表*/
    public MerchantApprovalExcution findApprovalList(MerchantApprovalDto merchantApprovalDto) {
        String hzn_approval_status=merchantApprovalDto.getHzn_approval_status();
        String hzn_search_content=merchantApprovalDto.getHzn_search_content();
        String sort=merchantApprovalDto.getSort();
        String  order=merchantApprovalDto.getOrder();
        int rows=merchantApprovalDto.getRows();
        int page=merchantApprovalDto.getPage();

        try {
            if(hzn_approval_status!=null||hzn_search_content!=null){
                rows=20;
                page=1;
            }
            int offset = (page - 1) * rows;
            List<MerchantApprovalInfo> findApprovalList=merchantApprovalDao.findApprovalList(hzn_approval_status,hzn_search_content,sort,order,offset,rows);
            if (findApprovalList != null) {
                for (MerchantApprovalInfo mer : findApprovalList) {
                    String applyTime = mer.getApplyTime();
                    String auditTime = mer.getAuditTime();
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if (applyTime!=null) {
                        Date date = fmt.parse(applyTime);
                        String s = fmt.format(date);
                        mer.setApplyTime(s);
                    }

                    if (auditTime!=null) {
                        Date date = fmt.parse(auditTime);
                        String s = fmt.format(date);
                        mer.setAuditTime(s);
                    }
                }
                int total = merchantApprovalDao.findListCount(hzn_approval_status,hzn_search_content);
                HashMap map=new HashMap();
                map.put("rows",findApprovalList);
                map.put("total",total);
                return  new MerchantApprovalExcution(MerchantApprovalEnum.FIND_SUCCESS,map);
            }
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
        return null;
    }
    /*查询详情*/
    public MerchantApprovalExcution findApprovalByID(MerchantApprovalDto merchantApprovalDto) {
        int id=merchantApprovalDto.getId();
        try {
            MerchantApprovalInfo merchantApprovalInfo = merchantApprovalDao.findMerchantByID(id);
            String applyTime = merchantApprovalInfo.getApplyTime();
            String auditTime = merchantApprovalInfo.getAuditTime();
            if (applyTime!=null) {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = fmt.parse(applyTime);
                String s = fmt.format(date);
                merchantApprovalInfo.setApplyTime(s);
            }

            if (auditTime!=null) {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = fmt.parse(auditTime);
                String s = fmt.format(date);
                merchantApprovalInfo.setAuditTime(s);
            }
            return  new MerchantApprovalExcution(MerchantApprovalEnum.FIND_SUCCESS,merchantApprovalInfo);
        } catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /*提交审核结果*/
    public MerchantApprovalExcution result(MerchantApprovalDto merchantApprovalDto){
        String approval_result=merchantApprovalDto.getApproval_result();
        String employees_id=merchantApprovalDto.getEmployees_id();
        String note=merchantApprovalDto.getNote();
        int approval_id=merchantApprovalDto.getApproval_id();
        String company_name=merchantApprovalDto.getCompany_name();
        String head=merchantApprovalDto.getHead();
        String company_address=merchantApprovalDto.getCompany_address();
        String longitude=merchantApprovalDto.getLongitude();
        String latitude=merchantApprovalDto.getLatitude();
        String job=merchantApprovalDto.getJob();
        String phone=merchantApprovalDto.getPhone();
        String logo_url=merchantApprovalDto.getLogo_url();
        int user_id=merchantApprovalDto.getUser_id();
        String url=merchantApprovalDto.getUrl();
        try {
            int flagApp = merchantApprovalDao.updateRseult(approval_result,employees_id,note,approval_id);
            if (flagApp<0){
                throw new UpdateDatabaseException("更改失败");
            }else {
                if(approval_result.equals("审核通过")){
                    int	flagUpAcc =merchantApprovalDao.updateMerchantMsg(company_name,head,company_address,longitude,latitude,job,phone,url,user_id);
                    if(flagUpAcc<=0){
                        throw new UpdateDatabaseException("更改失败");
                    }
                    int flagUpPor =merchantApprovalDao.updateMerchantPortrait(logo_url,user_id);
                    if(flagUpPor<=0){
                        throw new UpdateDatabaseException("更改失败");
                    }else{
                        return new MerchantApprovalExcution(MerchantApprovalEnum.UP_SUCCESS,null);
                    }
                }else {
                    return new MerchantApprovalExcution(MerchantApprovalEnum.UP_SUCCESS,null);
                }
            }

        } catch (UpdateDatabaseException  u){
            throw u;
        } catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }

    }


}
