package com.controller;

import com.entity.Brand;
import com.service.BrandService;
import com.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @Autowired
    PageService pageService;
    //show brand
    @RequestMapping("show")
    public String showBrands(){
        return "brand";
    }
    //brand List
    @RequestMapping("/brandList")
    @ResponseBody
    public List<Brand> brandList(){
        return pageService.getBrands();
    }
    //add Brand
    @RequestMapping("/addBrand")
    public String addBrand(Brand brand, HttpSession session){
        brandService.addBrand(brand);
        updateBrandInSession(session);
        return "redirect:show";
    }

    //delete Brand
    @RequestMapping("/deleteBrand")
    @ResponseBody
    public String deleteBrand(@RequestBody Brand brand,HttpSession session){
        if(brandService.deleteBrand(brand)){
            updateBrandInSession(session);
            return "success";
        }else {
            return "wrong";
        }
    }

    //update Brand
    @RequestMapping("/updateBrand")
    @ResponseBody
    public String updateBrand(@RequestBody Brand brand,HttpSession session){
        if(brandService.updateBrand(brand)){
            updateBrandInSession(session);
            return "success";
        }else {
            return "wrong";
        }
    }

    //update brand-session
    public void updateBrandInSession(HttpSession session){
        List<Brand> brandList=pageService.getBrands();
        HashMap BrandSelect=new HashMap();
        for(int i=0;i<brandList.size();i++)
            BrandSelect.put(brandList.get(i).getBrandId(),0);
        session.setAttribute("Brands", brandList);
        session.setAttribute("BrandSelect",BrandSelect);
    }
}
