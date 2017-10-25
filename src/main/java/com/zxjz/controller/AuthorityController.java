package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.AuthorityExcution;
import com.zxjz.dto.in.AuthorityDto;
import com.zxjz.dto.in.StaffMemberDto;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController{
    @Autowired
    private AuthorityService authorityService;
    /**
     * 显示权限管理页面
     *
     * @return
     */
    @RequestMapping(value = "/showauthPage")
    public ModelAndView showauthPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("authority/authority");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询员工列表
     * @return
     */
    @RequestMapping(value = "getauthority",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getAuthManagement(AuthorityDto authorityDto){
        //参数验空
        try{
            AuthorityExcution findListAuthority = authorityService.findListAuthority(authorityDto);
            return BaseUIResult.returnJsonEasyUI(findListAuthority);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonEasyUI(authorityExcution);
        }

    }

    /**
     * 新增信息页面
     *
     * @return
     */
    @RequestMapping(value = "/addinfo")
    public ModelAndView addInfo() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("authority/addinfo");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 查询权限
     * @return
     */
    @RequestMapping(value = "checkauth",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String checkauth(){
        //参数验空
        try{
            AuthorityExcution findListAuthInfo = authorityService.findListAuthInfo();
            return BaseUIResult.returnJson(findListAuthInfo);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJson(authorityExcution);
        }

    }

    /**
     * 查询编号
     * @return
     */
    @RequestMapping(value = "checknum",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String checknum(){
        //参数验空
        try{
            AuthorityExcution findEmployeesNum = authorityService.findEmployeesNum();
            return BaseUIResult.returnJson(findEmployeesNum);
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJson(authorityExcution);
        }

    }

    /**
     * 新增员工
     * @param staffMemberDto
     * @return
     */
    @RequestMapping(value = "subemploy",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String subemploy(StaffMemberDto staffMemberDto){
        //参数验空
        try{
            AuthorityExcution addStaffMember = authorityService.addStaffMember(staffMemberDto);
            return BaseUIResult.returnJsonMSG(1,addStaffMember,"添加成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonMSG(0,authorityExcution,"添加失败！");
        }

    }

    /**
     * 修改信息页面
     *
     * @return
     */
    @RequestMapping(value = "/editinfo")
    public ModelAndView editInfo(StaffMemberDto staffMemberDto) {
        ModelAndView mv = new ModelAndView();
        try {
            AuthorityExcution findAuthority = authorityService.findAuthority(staffMemberDto);
            mv.addObject("data", findAuthority);
            mv.setViewName("authority/editinfo");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 修改员工
     * @param staffMemberDto
     * @return
     */
    @RequestMapping(value = "subedit",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String subedit(StaffMemberDto staffMemberDto){
        //参数验空
        try{
            AuthorityExcution updateStaffMember = authorityService.updateStaffMember(staffMemberDto);
            return BaseUIResult.returnJsonMSG(1,updateStaffMember,"修改成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.FIND_ERROR);
            return BaseUIResult.returnJsonMSG(0,authorityExcution,"修改失败！");
        }

    }

    /**
     * 显示删除页面
     * @param staffMemberDto
     * @return
     */
    @RequestMapping(value = "/deleteinfo")
    public ModelAndView deleteinfo(StaffMemberDto staffMemberDto) {
        ModelAndView mv = new ModelAndView();
        try {
            AuthorityExcution deleteAuthority = authorityService.deleteAuthority(staffMemberDto);
            mv.addObject("data", deleteAuthority);
            mv.setViewName("authority/deleteinfo");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 删除员工
     * @param staffMemberDto
     * @return
     */
    @RequestMapping(value = "subdelete",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String subdelete(StaffMemberDto staffMemberDto){
        //参数验空
        try{
            AuthorityExcution deleteStaffMember = authorityService.deleteStaffMember(staffMemberDto);
            return BaseUIResult.returnJsonMSG(1,deleteStaffMember,"删除成功！");
        } catch (Exception e){
            logger.error(e.getMessage(),e);
            AuthorityExcution authorityExcution = new AuthorityExcution(e.getMessage(), IndustryClassificationEnum.UPDATE_FAIL);
            return BaseUIResult.returnJsonMSG(0,authorityExcution,"删除失败！");
        }

    }
}
