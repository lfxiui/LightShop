package com.controller;

import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by AgZou on 2017/5/4.
 */
@Controller
public class PageController {
    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("page", pageService.getPage());
        mv.addObject("lights",pageService.getPageHotSales());
//        mv.addObject("elights",pageService.getPageEndSales());
        return mv;
    }
}
