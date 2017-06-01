package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by AgZou on 2017/5/13.
 */
@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/info")
    public ModelAndView info(HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userService.getUser(userId));
        mv.setViewName("information");
        return mv;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(String flag,String v,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        userService.updateUser(flag,v,userId);
        return "success";
    }
    @RequestMapping("/updatepwd")
    public ModelAndView updatepwd(String opwd,String npwd,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        ModelAndView mv=new ModelAndView();
        User user=userService.getUser(userId);
        if(opwd.equals(user.getLoginPwd())){
            userService.updateUser("LoginPwd",npwd,userId);
            user.setLoginPwd(npwd);}
        mv.addObject("user",user);
        mv.setViewName("information");
        return mv;
    }
    @RequestMapping("/checkopwd")
    @ResponseBody
    public String checkopwd(String opwd,HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        if(opwd.equals(userService.getUser(userId).getLoginPwd()))
            return "yes";
        else return  "no";
    }
}
