package com.controller;

import com.dao.PageDao;
import com.service.PageService;
import com.service.SearchService;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by AgZou on 2017/5/8.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;
    private final PageService pageService;

    @Autowired
    public SearchController(SearchService searchService, PageService pageService) {
        this.searchService = searchService;
        this.pageService = pageService;
    }

    @RequestMapping("")
    public ModelAndView search(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("search");
        return  mv;
    }
    @RequestMapping("/all")
    public ModelAndView searchAll(String operate, String name, Integer id, HttpSession session){
        ModelAndView mv=new ModelAndView();
        HashMap map=(HashMap) session.getAttribute("map");
        HashMap<Integer,Integer> BrandSelect= (HashMap<Integer,Integer>) session.getAttribute("BrandSelect");
        List<Integer> checkbox=new ArrayList<Integer>();
        int i=0;
        for(Integer key:BrandSelect.keySet()){
            if(BrandSelect.get(key)==1){
                checkbox.add(key);
            }
        }
       if(operate.equals("delete"))
           map.remove(name);
       else {
           map.put(name,id);
       }
       mv.addObject("results",searchService.getLightsByAll(map,checkbox));
       mv.setViewName("search");
        return mv;
    }
    @RequestMapping("/submit")
    public ModelAndView submit(@RequestParam(value = "checkbox",required = false) Integer[] checkbox,String flag,HttpSession session){
        ModelAndView mv=new ModelAndView();
        HashMap map=(HashMap) session.getAttribute("map");
        mv.addObject("results",searchService.getLightsByFrom(map,flag,checkbox));
        mv.setViewName("search");
        return mv;
    }
    @RequestMapping("/select")
    @ResponseBody
    public String select(Integer id,String operate,HttpSession session){
        HashMap BrandSelect =(HashMap) session.getAttribute("BrandSelect");
        if(operate.equals("delete"))
            BrandSelect.put(id,0);
        else BrandSelect.put(id,1);
        return "success";
    }
    @RequestMapping("/type")
    public ModelAndView type(String name,Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("results",searchService.getLightsByType(name,id));
        mv.setViewName("search");
        return  mv;
    }
}
