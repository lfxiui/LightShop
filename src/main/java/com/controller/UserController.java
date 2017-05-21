package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView info(Integer userId){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userService.getUser(1));
        mv.setViewName("information");
        return mv;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(String flag,String v,Integer userId){
        System.out.println(flag+v);
        userService.updateUser(flag,v,1);
        return "success";
    }
    @RequestMapping("/updatepwd")
    public ModelAndView updatepwd(String opwd,String npwd){
        ModelAndView mv=new ModelAndView();
        User user=userService.getUser(1);
        if(opwd.equals(user.getLoginPwd())){
            userService.updateUser("LoginPwd",npwd,1);
            user.setLoginPwd(npwd);}
        mv.addObject("user",user);
        mv.setViewName("information");
        return mv;
    }
    @RequestMapping("/checkopwd")
    @ResponseBody
    public String checkopwd(String opwd){
        if(opwd.equals(userService.getUser(1).getLoginPwd()))
            return "yes";
        else return  "no";
    }
}
