package com.controller;

import com.entity.Brand;
import com.entity.Page;
import com.service.LightService;
import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by AgZou on 2017/5/4.
 */
@Controller
public class PageController {
    private final PageService pageService;
    private final LightService lightService;
    @Autowired
    public PageController(PageService pageService, LightService lightService) {
        this.pageService = pageService;
        this.lightService = lightService;
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
       if(session.getAttribute("page")==null) {
           List<Brand> brandList=pageService.getBrands();
           HashMap BrandSelect=new HashMap();
           for(int i=0;i<brandList.size();i++)
               BrandSelect.put(brandList.get(i).getBrandId(),0);
           session.setAttribute("page", pageService.getPage());
           session.setAttribute("lights", pageService.getPageHotSales());
           session.setAttribute("Brands", brandList);
           session.setAttribute("Styles", pageService.getStyles());
           session.setAttribute("Catagorys", pageService.getCatagorys());
           session.setAttribute("Locates", pageService.getLocates());
           session.setAttribute("Stuffs", pageService.getStuffs());
           session.setAttribute("map",new HashMap());
           session.setAttribute("BrandSelect",BrandSelect);
           String flag="";
           session.setAttribute("flag",flag);
       }
//        mv.addObject("elights",pageService.getPageEndSales());
        return mv;
    }
    @RequestMapping("/page")
    public String page(){
        return "page";
    }
    @RequestMapping("/page/submit")
    public String submit(Page page){
        pageService.updatePage(page);
        return "page";
    }
    @RequestMapping("/page/submit1")
    public String submit1(Page page){
        pageService.updatePage1(page);
        return "page";
    }
    @RequestMapping("/page/getLight")
    @ResponseBody
    public String getLight(Integer lightId){
        if(lightService.getLightById(lightId)==null)
            return "no";
        else  return "yes";
    }
}
