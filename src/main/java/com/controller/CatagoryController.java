package com.controller;

import com.entity.Catagory;
import com.service.CatagoryService;
import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Controller
@RequestMapping("/catagory")
public class CatagoryController {
    @Autowired
    CatagoryService catagoryService;
    @Autowired
    PageService pageService;
    @RequestMapping("/show")
    public String show(){
        return "catagory";
    }
    @RequestMapping("/catagoryList")
    @ResponseBody
    public List<Catagory> catagoryList(){
        return pageService.getCatagorys();
    }
    //add catagory
    @RequestMapping("/addCatagory")
    public String addCatagory(Catagory catagory, HttpSession session){
        catagoryService.addCatagory(catagory);
        updateCatagoryInSession(session);
        return "redirect:show";
    }

    //delete catagory
    @RequestMapping("deleteCatagory")
    @ResponseBody
    public String deleteCataGory(@RequestBody Catagory catagory,HttpSession session){
        if(catagoryService.deleteCataGory(catagory)){
            updateCatagoryInSession(session);
            return "success";
        }else {
            return "wrong";
        }
    }

    //update catagory
    @RequestMapping("updateCatagory")
    @ResponseBody
    public String updateCataGory(@RequestBody Catagory catagory,HttpSession session){
        if(catagoryService.updateCataGory(catagory)){
            updateCatagoryInSession(session);
            return "success";
        }else {
            return "wrong";
        }
    }

    //update catagory-session
    public void updateCatagoryInSession(HttpSession session){
        session.setAttribute("Catagorys", pageService.getCatagorys());
    }
}
