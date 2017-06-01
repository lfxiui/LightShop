package com.service;

import com.dao.PageDao;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PageService {
    private final PageDao pageDao;

    @Autowired
    public PageService(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    public Page getPage(){
        return pageDao.getPage();
    }
    public List<Light> getPageHotSales(){
        List<Light> lights=new ArrayList<Light>();
        Page page=pageDao.getPage();
        if(page.getHotSale1()!=null&&page.getHotSale1()!=0)
            lights.add(page.getLightByHotSale1());
        if(page.getHotSale2()!=null&&page.getHotSale2()!=0)
            lights.add(page.getLightByHotSale2());
        if(page.getHotSale3()!=null&&page.getHotSale3()!=0)
            lights.add(page.getLightByHotSale3());
        if(page.getHotSale4()!=null&&page.getHotSale4()!=0)
            lights.add(page.getLightByHotSale4());
        if(page.getHotSale5()!=null&&page.getHotSale5()!=0)
            lights.add(page.getLightByHotSale5());
        if(page.getHotSale6()!=null&&page.getHotSale6()!=0)
            lights.add(page.getLightByHotSale6());
        if(page.getHotSale7()!=null&&page.getHotSale7()!=0)
            lights.add(page.getLightByHotSale7());
        if(page.getHotSale8()!=null&&page.getHotSale8()!=0)
            lights.add(page.getLightByHotSale8());
        return lights;
    }
    public List<Light> getPageEndSales(){
        List<Light> elights=new ArrayList<Light>();
        Page page=pageDao.getPage();
        if(page.getEndSale1()!=null&&page.getEndSale1()!=0)
            elights.add(page.getLightByEndSale1());
        if(page.getEndSale2()!=null&&page.getEndSale2()!=0)
            elights.add(page.getLightByEndSale2());
        return elights;
    }
    public List<Brand> getBrands(){
       return  pageDao.getBrands();
    }
    public List<Style> getStyles(){
        return pageDao.getStyles();
    }
    public List<Stuff> getStuffs(){
        return pageDao.getStuffs();
    }
    public List<Locate> getLocates(){
        return pageDao.getLocates();
    }
    public List<Catagory> getCatagorys(){
        return pageDao.getCatagorys();
    }
    public void updatePagePhoto(Integer imgNumber,String filename){
        Page page=this.getPage();
        if(imgNumber==1)
            page.setCarouselImg1(filename);
        if(imgNumber==2)
            page.setCarouselImg2(filename);
        if(imgNumber==3)
            page.setCarouselImg3(filename);
        pageDao.updatePage(page);
    }
    public void updatePage(Page page){
        Page page1=this.getPage();
        page.setEndSale1(page1.getEndSale1());
        page.setEndSale2(page1.getEndSale2());
        page.setCarouselImg3(page1.getCarouselImg3());
        page.setCarouselImg2(page1.getCarouselImg2());
        page.setCarouselImg3(page1.getCarouselImg3());
        page.setId(1);
        pageDao.updatePage(page);
    }
    public void updatePage1(Page page){
        Page page1=this.getPage();
        page1.setEndSale1(page.getEndSale1());
        page1.setEndSale1(page.getEndSale2());
        pageDao.updatePage(page);
    }
}
