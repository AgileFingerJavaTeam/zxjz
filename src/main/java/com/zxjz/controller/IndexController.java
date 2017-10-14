package com.zxjz.controller;

import com.zxjz.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController extends BaseController{
    @RequestMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("index/index");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }
    @RequestMapping(value = "/main")
    public ModelAndView main() {

        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("index/main");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }
}
