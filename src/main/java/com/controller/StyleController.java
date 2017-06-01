package com.controller;

import com.entity.Style;
import com.service.PageService;
import com.service.StyleService;
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
@RequestMapping("/style")
public class StyleController {
    @Autowired
    PageService pageService;
    @Autowired
    StyleService styleService;
    @RequestMapping("/show")
    public String show(){
        return "style";
    }
    public void updateStyleInSession(HttpSession session){
        session.setAttribute("Styles", pageService.getStyles());
    }
    @RequestMapping("/styleList")
    @ResponseBody
    public List<Style> styleList(){
        return pageService.getStyles();
    }
    //addStyle
    @RequestMapping("/addStyle")
    public String addStyle(Style style,HttpSession session){
styleService.addStyle(style);
updateStyleInSession(session);
return "redirect:show";
    }
    @RequestMapping("/deleteStyle")
    @ResponseBody
    public String deleteStyle(@RequestBody Style style,HttpSession session){
if (styleService.deleteStyle(style)){
    updateStyleInSession(session);return "success";
}else return "wrong";
    }
    @RequestMapping("/updateStyle")
    @ResponseBody
    public String updateStyle(@RequestBody Style style,HttpSession session){
        if (styleService.updateStyle(style)){
            updateStyleInSession(session);return "success";
        }else return "wrong";
    }
}
