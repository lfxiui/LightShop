package com.controller;

import com.dao.PageDao;
import com.service.PageService;
import com.service.SearchService;
import com.tools.PageMessage;
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

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;

    }

    @RequestMapping("")
    public ModelAndView search(){
        ModelAndView mv=new ModelAndView();
        PageMessage pageMessage=searchService.getLights(6,1);
        mv.addObject("results",pageMessage.getList());
        pageMessage.setList(null);
        mv.addObject("pageMessage",pageMessage);
        mv.setViewName("search");
        return  mv;
    }
    @RequestMapping("/all")
    public ModelAndView searchAll(String operate, String name, Integer id,Integer page, HttpSession session){
        ModelAndView mv=new ModelAndView();
        Integer sort;
        if(session.getAttribute("sort")!=null)
            sort= (Integer) session.getAttribute("sort");
        else sort=0;
        String flag="";
        if(page!=null)
            flag=(String)session.getAttribute("flag");

        else{
        session.setAttribute("flag",flag);
        page=1;}
        HashMap map=(HashMap) session.getAttribute("map");
        HashMap<Integer,Integer> BrandSelect= (HashMap<Integer,Integer>) session.getAttribute("BrandSelect");
        List<Integer> checkbox=new ArrayList<Integer>();
        for(Integer key:BrandSelect.keySet()){
            if(BrandSelect.get(key)==1){
                checkbox.add(key);
            }
        }
       if(operate.equals("delete"))
           map.remove(name);
       else if(operate.equals("add")){
           map.put(name,id);
       }
       PageMessage pageMessage=searchService.getLightsByAll(map,checkbox,6,page,flag,sort);
       mv.addObject("results",pageMessage.getList());
       pageMessage.setList(null);
       mv.addObject("pageMessage",pageMessage);
       mv.setViewName("search");
        return mv;
    }
    @RequestMapping("/submit")
    public ModelAndView submit(@RequestParam(value = "checkbox",required = false) Integer[] checkbox,String flag,HttpSession session){
        ModelAndView mv=new ModelAndView();
        session.setAttribute("flag",flag);
        HashMap map=(HashMap) session.getAttribute("map");
        PageMessage pageMessage=searchService.getLightsByFrom(map,flag,checkbox,6,1);
        mv.addObject("results",pageMessage.getList());
        pageMessage.setList(null);
        mv.addObject("pageMessage",pageMessage);
        mv.setViewName("search");
        return mv;
    }
    @RequestMapping("/select")
    @ResponseBody
    public String select(Integer id,String operate,HttpSession session){
        HashMap BrandSelect =(HashMap) session.getAttribute("BrandSelect");
        session.setAttribute("flag","");
        if(operate.equals("delete"))
            BrandSelect.put(id,0);
        else BrandSelect.put(id,1);
        return "success";
    }
    @RequestMapping("/type")
    public ModelAndView type(String name,Integer id){
        ModelAndView mv=new ModelAndView();
        PageMessage pageMessage=searchService.getLightsByType(name,id,6,1);
        mv.addObject("results",pageMessage.getList());
        pageMessage.setList(null);
        mv.addObject("pageMessage",pageMessage);
        mv.setViewName("search");
        return  mv;
    }
    @RequestMapping("/sort")
    public ModelAndView sort(HttpSession session,Integer sort){
        ModelAndView mv=new ModelAndView();
        session.setAttribute("sort",sort);
        mv.setViewName("search");
        HashMap map=(HashMap) session.getAttribute("map");
        HashMap<Integer,Integer> BrandSelect= (HashMap<Integer,Integer>) session.getAttribute("BrandSelect");
        List<Integer> checkbox=new ArrayList<Integer>();
        for(Integer key:BrandSelect.keySet()){
            if(BrandSelect.get(key)==1){
                checkbox.add(key);
            }
        }
        PageMessage pageMessage;
        if(sort==1)
        { pageMessage=searchService.getLightBySort1(map,checkbox,(String) session.getAttribute("flag"),6,1);
           mv.addObject("results",pageMessage.getList());
           pageMessage.setList(null);
           mv.addObject("pageMessage",pageMessage);
        }
        if(sort==2){
            pageMessage=searchService.getLightBySort2(map,checkbox,(String) session.getAttribute("flag"),6,1);
            mv.addObject("results",pageMessage.getList());
            pageMessage.setList(null);
            mv.addObject("pageMessage",pageMessage);
        }

        if(sort==3){
            pageMessage=searchService.getLightBySort3(map,checkbox,(String) session.getAttribute("flag"),6,1);
            mv.addObject("results",pageMessage.getList());
            pageMessage.setList(null);
            mv.addObject("pageMessage",pageMessage);
        }

        if(sort==4)
        {
            pageMessage=searchService.getLightBySort4(map,checkbox,(String) session.getAttribute("flag"),6,1);
            mv.addObject("results",pageMessage.getList());
            pageMessage.setList(null);
            mv.addObject("pageMessage",pageMessage);
        }
        return mv;
    }
}
