package com.controller;

import com.entity.*;
import com.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by AgZou on 2017/5/24.
 */
@Controller
@RequestMapping("/statistic")
public class StatisticsController {
    private final LightService lightService;

    @Autowired
    public StatisticsController(LightService lightService) {
        this.lightService = lightService;
    }

    @RequestMapping("/show")
    public String show(){
        return "statistics";
    }
    @RequestMapping("/getLight")
    @ResponseBody
    public Light getLight(Integer lightId){
       return lightService.getLightById(lightId);
    }
    @RequestMapping("/getType")
    @ResponseBody
    public List<Map> getType(String type, HttpSession session){
        if(type.equals("catagory"))
            return  lightService.getCatagoryMap((List<Catagory>) session.getAttribute("Catagorys"));
        else if(type.equals("brand"))
            return lightService.getBrandsMap((List<Brand>) session.getAttribute("Brands"));
        else if(type.equals("style"))
            return lightService.getStyleMap((List<Style>) session.getAttribute("Styles"));
        else if(type.equals("stuff"))
            return  lightService.getSutffMap((List<Stuff>) session.getAttribute("Stuffs"));
        else if(type.equals("locate"))
            return lightService.getLocateMap((List<Locate>) session.getAttribute("Locates"));
        else return null;
    }
}
