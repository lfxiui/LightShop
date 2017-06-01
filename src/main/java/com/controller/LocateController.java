package com.controller;

import com.entity.Locate;
import com.service.LocateService;
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
@RequestMapping("/locate")
public class LocateController {
    @Autowired
    PageService pageService;
    @Autowired
    LocateService locateService;
    @RequestMapping("/show")
    public String show(){
        return "locate";
    }
    @RequestMapping("/locateList")
    @ResponseBody
    public List<Locate> locateList(){
        return pageService.getLocates();
    }
    //add locate
    @RequestMapping("/addLocate")
    public String addLocate(Locate locate,HttpSession session){
        locateService.addLocate(locate);
        updateLocateInSession(session);
        return "redirect:show";
    }

    //deleteLocate
    @RequestMapping("/deleteLocate")
    @ResponseBody
    public String deleteLocate(@RequestBody Locate locate,HttpSession session){
        if (locateService.deleteLocate(locate)){
            updateLocateInSession(session);
            return "success";
        }else return "wrong";
    }

    //update locate
    @RequestMapping("/updateLocate")
    @ResponseBody
    public String updateLocate(@RequestBody Locate locate,HttpSession session){
        if (locateService.updateLocate(locate)){
            updateLocateInSession(session);
            return "success";
        }else return "wrong";
    }

    //update locate-session
    public void updateLocateInSession(HttpSession session){
        session.setAttribute("Locates", pageService.getLocates());    }
}
