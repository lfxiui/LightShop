package com.controller;

import com.entity.Stuff;
import com.service.PageService;
import com.service.StuffService;
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
@RequestMapping("/stuff")
public class StuffController {
    @Autowired
    PageService pageService;
    @Autowired
    StuffService stuffService;
    @RequestMapping("/show")
    public String show(){
        return "stuff";
    }
    public void updateStuffInSession(HttpSession session){
        session.setAttribute("Stuffs", pageService.getStuffs());
    }
    @RequestMapping("/stuffList")
    @ResponseBody
    public List<Stuff> stuffList(){
        return pageService.getStuffs();
    }
    //add stuff
    @RequestMapping("/addStuff")
    public String addStuff(Stuff stuff,HttpSession session){
stuffService.addStuff(stuff);
updateStuffInSession(session);
return "redirect:show";
    }
    //delete stuff
    @RequestMapping("/deleteStuff")
    @ResponseBody
    public String deleteStuff(@RequestBody Stuff stuff,HttpSession session){
if (stuffService.deleteStuff(stuff)){
    updateStuffInSession(session);
    return "success";
}else return "wrong";
    }
    //updateStuff
    @RequestMapping("/updateStuff")
    @ResponseBody
    public String updateStuff(@RequestBody Stuff stuff,HttpSession session){
if (stuffService.updateStuff(stuff)){
    updateStuffInSession(session);
    return "success";
}else return "wrong";
    }
}
