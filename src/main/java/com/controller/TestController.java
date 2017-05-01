package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AgZou on 2017/4/29.
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }
}
