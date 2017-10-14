package com.zxjz.controller;

import com.zxjz.base.BaseAPIResult;
import com.zxjz.base.BaseController;
import com.zxjz.dto.excution.ManagementPartExcuton;
import com.zxjz.dto.excution.UpdateIsOverExcution;
import com.zxjz.dto.excution.UpdatePauseExcution;
import com.zxjz.dto.excution.UpdateRejectExcution;
import com.zxjz.dto.in.ManagementPartDto;
import com.zxjz.dto.in.UpdatePauseDto;
import com.zxjz.dto.in.UpdateRejectDto;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.enums.UpdatePauseEnum;
import com.zxjz.service.ManagementPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ManagementPart")
public class ManagementPartController extends BaseController{
    @Autowired
    private ManagementPartService managementPartService;

    /**
     * 获取职位管理
     * @param managementPartDto
     * @return
     */
    @RequestMapping(value = "postStuGenEvaluation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult postStuGenEvaluation(@RequestBody ManagementPartDto managementPartDto){
        //参数验空
        try{
            ManagementPartExcuton managementPartExcuton = managementPartService.findManagementPart(managementPartDto);
            return new BaseAPIResult(1,managementPartExcuton);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            ManagementPartExcuton managementPartExcuton = new ManagementPartExcuton(e.getMessage(), StuPersonalEnum.FIND_ERROR);
            return new BaseAPIResult(0,managementPartExcuton);
        }

    }

    /**
     * 暂停
     * @param updatePauseDto
     * @return
     */
    @RequestMapping(value = "getPause",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getPause(@RequestBody UpdatePauseDto updatePauseDto){
        //参数验空
        try{
            UpdatePauseExcution updatePauseExcution = managementPartService.updatePause(updatePauseDto);
            return new BaseAPIResult(1,updatePauseExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            UpdatePauseExcution updatePauseExcution = new UpdatePauseExcution(e.getMessage(), UpdatePauseEnum.UPDATE_ERROR);
            return new BaseAPIResult(0,updatePauseExcution);
        }

    }

    /**
     * 审核驳回
     * @param updateRejectDto
     * @return
     */
    @RequestMapping(value = "getAuditFailed",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult getAuditFailed(@RequestBody UpdateRejectDto updateRejectDto){
        //参数验空
        try{
            UpdateRejectExcution updateRejectExcution = managementPartService.updateReject(updateRejectDto);
            return new BaseAPIResult(1,updateRejectExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            UpdateRejectExcution updateRejectExcution = new UpdateRejectExcution(e.getMessage(), UpdatePauseEnum.UPDATE_ERROR);
            return new BaseAPIResult(0,updateRejectExcution);
        }

    }

    /**
     * 结束
     * @param updateRejectDto
     * @return
     */
    @RequestMapping(value = "getHasBeen",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseAPIResult updateIsOver(@RequestBody UpdateRejectDto updateRejectDto){
        //参数验空
        try{
            UpdateIsOverExcution updateIsOverExcution = managementPartService.updateIsOver(updateRejectDto);
            return new BaseAPIResult(1,updateIsOverExcution);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            UpdateIsOverExcution updateIsOverExcution = new UpdateIsOverExcution(e.getMessage(), UpdatePauseEnum.UPDATE_ERROR);
            return new BaseAPIResult(0,updateIsOverExcution);
        }

    }
}
