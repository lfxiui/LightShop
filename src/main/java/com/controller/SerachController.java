package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by AgZou on 2017/5/8.
 */
@Controller
public class SerachController {
    @RequestMapping("/search")
    public ModelAndView search(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("search");
        return  mv;
    }
}
