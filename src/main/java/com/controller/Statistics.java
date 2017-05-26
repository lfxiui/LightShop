package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AgZou on 2017/5/24.
 */
@Controller
@RequestMapping("/statistic")
public class Statistics {
    @RequestMapping("/show")
    public String show(){
        return "statistics";
    }
}
