package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseResult;
import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.excution.StationInfoExcution;
import com.zxjz.dto.in.StationDto;
import com.zxjz.enums.StationInfoEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.StationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("GyStation")
public class StationController extends BaseController {
    @Autowired
    private StationInfoService stationInfoService;

    /**
     * 显示职位类型管理页面
     * @return
     */
    @RequestMapping(value = "/showStation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public ModelAndView showStation(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("evaluation/details");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询父类职位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/StationList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> findParentJobList (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findParentJobList(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示添加父类岗位页面
     * @return
     */
    @RequestMapping(value = "/getTanStation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showAddParentJobPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("evaluation/adddetails");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 添加父类岗位类型
     * @return
     */
    @RequestMapping(value = "/AddStationList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> addParentJobType (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.addParentJobType(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (InsertInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.ADD_PARENT_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示编辑父类岗位页面
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/getEditMvDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showEditParentJobPage (StationDto stationDto){
        ModelAndView mv = new ModelAndView();
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findParentJobInfo(stationDto);
            mv.addObject("data", stationInfoExcution);
            mv.setViewName("evaluation/editdetails");
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_PARENT_JOB_FAIL);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 编辑父类岗位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/editDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> editParentJobType (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.editParentJobInfo(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (UpdateInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.EDIT_PARENT_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示删除父类岗位页面
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/getDelMvDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDeleteParentJobPage (StationDto stationDto){
        ModelAndView mv = new ModelAndView();
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findParentJobInfo(stationDto);
            mv.addObject("data", stationInfoExcution);
            mv.setViewName("evaluation/deldetails");
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_PARENT_JOB_FAIL);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 删除父类岗位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/delDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> deleteParentJobType (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.deleteParentJobType(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (UpdateInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.DELETE_PARENT_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示子类岗位页面
     * @return
     */
    @RequestMapping(value = "/showStation2",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showChildJobList(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("evaluation2/details2");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询子类岗位列表
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/TwoStationList",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> findChildJobInfo(StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findChildJobList(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示子类岗位添加页面
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/getTwoTanStation",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showChildAddPage (StationDto stationDto){
        String pid = stationDto.getPid();
        String pname = stationDto.getPname();
        ModelAndView mv = new ModelAndView();
        try {
            mv.addObject("data",pname );
            mv.setViewName("evaluation2/adddetails");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询父类信息
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/getPInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> findParentJobInfo(StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findParentJob(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 添加子类岗位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/AddCInfo",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> addChildJobType (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.addChildJobType(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (InsertInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.ADD_CHILD_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示编辑子类岗位页面
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/showEditDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showEditChildJobPage (StationDto stationDto){
        ModelAndView mv = new ModelAndView();
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findChildJobInfo(stationDto);
            mv.addObject("data", stationInfoExcution);
            mv.setViewName("evaluation2/editdetails");
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_FAIL);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     *删除子类岗位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/editCDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> editChildJobType(StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.editChildJobType(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (UpdateInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.EDIT_CHILD_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }

    /**
     * 显示删除子类岗位类型页面
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/showDelCClassify",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView showDelectChildJobType (StationDto stationDto){
        ModelAndView mv = new ModelAndView();
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.findChildJobInfo(stationDto);
            mv.addObject("data", stationInfoExcution);
            mv.setViewName("evaluation2/deldetails");
        }catch (QueryInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.FIND_FAIL);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 删除子类岗位类型
     * @param stationDto
     * @return
     */
    @RequestMapping(value = "/delCDetails",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<StationInfoExcution> delectChildJobType (StationDto stationDto){
        try {
            StationInfoExcution stationInfoExcution = stationInfoService.delectChildJobType(stationDto);
            return new BaseResult<StationInfoExcution>(1,stationInfoExcution);
        }catch (UpdateInnerErrorException e){
            StationInfoExcution stationInfoExcution = new StationInfoExcution(StationInfoEnum.DELETE_CHILD_JOB_FAIL);
            return new BaseResult<StationInfoExcution>(0,stationInfoExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return new BaseResult<StationInfoExcution>(0,e.getMessage());
        }
    }
}
