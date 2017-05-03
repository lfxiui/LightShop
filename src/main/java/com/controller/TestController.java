package com.controller;

import com.entity.Statistics;
import com.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by AgZou on 2017/4/29.
 */
@Controller
public class TestController {
    @Autowired
    public StatisticsService statisticsService;
    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }
    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("stat",(List<Statistics>)statisticsService.getStatistics());
        mv.setViewName("show");
        return mv;
    }
}
