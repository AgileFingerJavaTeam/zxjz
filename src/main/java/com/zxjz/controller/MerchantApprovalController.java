package com.zxjz.controller;

import com.zxjz.base.BaseController;
import com.zxjz.base.BaseUIResult;
import com.zxjz.dto.excution.MerchantApprovalExcution;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.in.MerchantApprovalDto;
import com.zxjz.dto.in.RecruitApprovalDto;
import com.zxjz.entity.LandFallInfo;
import com.zxjz.enums.MerchantApprovalEnum;
import com.zxjz.enums.RecruitApprovalEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.service.MerchantApprovalService;
import com.zxjz.service.RecruitApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/MerchantApproval")
public class MerchantApprovalController extends BaseController{
    @Autowired
    private MerchantApprovalService merchantApprovalService;

    /**
     * 显示招聘信息页面
     *
     * @return
     */
    @RequestMapping(value = "/showMerchantAccountPage")
    public ModelAndView showMerchantAccountPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("approval/merchant_approval");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }


    /**
     * 查询招聘列表信息
     *
     * @return
     */
    @RequestMapping(value = "/merchantAccount",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getinfoList(MerchantApprovalDto merchantApprovalDto) {

        try {
            MerchantApprovalExcution merchantApprovalExcution=merchantApprovalService.findApprovalList(merchantApprovalDto);
            return BaseUIResult.returnJsonEasyUI(merchantApprovalExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            MerchantApprovalExcution merchantApprovalExcution = new MerchantApprovalExcution(MerchantApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(merchantApprovalExcution);
        }

    }

    /**
     * 显示审核信息页面
     *
     * @return
     */
    @RequestMapping(value = "/approvalMerchantAccount",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public ModelAndView editPS(MerchantApprovalDto merchantApprovalDto) {
        ModelAndView mv = new ModelAndView();
        HttpSession session=this.getRequest().getSession();
        try {
            MerchantApprovalExcution info =merchantApprovalService.findApprovalByID(merchantApprovalDto);
            LandFallInfo landfall=(LandFallInfo) session.getAttribute("user");
            int id=landfall.getEmployeesId();
            String name=  landfall.getEmployeesName();
            mv.addObject("id",id);
            mv.addObject("name",name);
            mv.addObject("data", info);
            mv.setViewName("approval/approvalMerchant");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
        }
        return mv;
    }

    /**
     * 审核商家账号详细信息
     *
     * @return
     */
    @RequestMapping(value = "/hzn_approvalMerchant",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String approvalMerchant(MerchantApprovalDto merchantApprovalDto) {

        try {
           MerchantApprovalExcution merchantApprovalExcution=merchantApprovalService.result(merchantApprovalDto);
            return BaseUIResult.returnJsonMSG(1,merchantApprovalExcution,"更改成功");
        } catch (UpdateDatabaseException e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,recruitApprovalExcution,"更改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            RecruitApprovalExcution recruitApprovalExcution = new RecruitApprovalExcution(RecruitApprovalEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(0,recruitApprovalExcution,"更改失败");
        }
    }


    /**
     * 显示审核商家地址地图
     *
     * @return
     */
    @RequestMapping(value = "/showMerchantMapPage")
    public ModelAndView showMerchantMapPage() {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("approval/hzn_map");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }



}
