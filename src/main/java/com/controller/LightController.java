package com.controller;

import com.entity.Light;
import com.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public List<Light> getLights(){

        return null;
    }

    //获取灯饰详情
    @RequestMapping("/lightInfo")
    public String getLightById(Model model)
    {
        int lightId = 1;
        Light light = lightService.getLightById(lightId);
        model.addAttribute("light",light);
        model.addAttribute("comments",light.getCommentsByLightId());
        System.out.println(light.getImage1());
        return "light";
    }

    //增加灯饰
    public void addLight(Light light){

    }

    //删除灯饰
    public void deleteLightById(int lightId){

    }

    //修改灯饰
    public void updateLight(Light light){

    }
}
