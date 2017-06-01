package com.controller;

import com.entity.Light;
import com.entity.Wishlist;
import com.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/2.
 */
@Controller
@RequestMapping("/light")
public class LightController {

    @Autowired
    LightService lightService;

    @RequestMapping("/show")
    public String show() {
        return "light";
    }

    //获取所有灯饰
    @RequestMapping("/getLights")
    @ResponseBody
    public List<Light> getLights(){
      return  lightService.getLights();
    }

    //获取灯饰详情
    @RequestMapping("/lightInfo")
    public String getLightById(Model model,int lightId)
    {
        Light light = lightService.getLightById(lightId);
        light.setClick(light.getClick() + 1);
        lightService.updateLight(light);
        model.addAttribute("light",light);
        model.addAttribute("comments",light.getCommentsByLightId());
        return "light";
    }

    //增加灯饰
    @RequestMapping("/addLight")
    public String  addLight(Light light){
        lightService.addLight(light);
        return "lightA";
    }

    //删除灯饰
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteLightById(int lightId){
        lightService.deleteLightById(lightId);
        return  "success";
    }

    //修改灯饰
    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public String updateLight(@RequestBody Light light){
        lightService.updateLight(light);
        return "success";
    }
    @RequestMapping("/lightA")
    public String lightA(){
        return "lightA";
    }

    @RequestMapping("/addWishlist")
    @ResponseBody
    public String addWishlist(@RequestBody Wishlist wishlist,HttpSession session){
        wishlist.setUserId((Integer) session.getAttribute("userId"));
        lightService.addWishList(wishlist);
        return "success";
    }
}
