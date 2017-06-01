package com.controller;

import com.entity.Brand;
import com.entity.User;
import com.service.PageService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by AgZou on 2017/5/31.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;
    private final PageService pageService;

    @Autowired
    public LoginController(UserService userService, PageService pageService) {
        this.userService = userService;
        this.pageService = pageService;
    }

    @RequestMapping("")
    public  String login(){
        return "login";
    }
    @RequestMapping("/submit")
    public ModelAndView submit(HttpServletRequest request,String loginId){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        mv.addObject("msg", "账号或密码错误");
        HttpSession session=request.getSession();
        String pwd=request.getParameter("password");
        User user=userService.getUserByLoginId(loginId);
        if(user!=null&&user.getLoginPwd().equals(pwd)){
            List<Brand> brandList=pageService.getBrands();
            HashMap BrandSelect=new HashMap();
            for(int i=0;i<brandList.size();i++)
                BrandSelect.put(brandList.get(i).getBrandId(),0);
            session.setAttribute("userId",user.getUserId());
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
            if(user.getUserRoleId()==1)
                mv.setViewName("ordersManager");
            else  mv.setViewName("index");
        }
        return mv;
    }
}
