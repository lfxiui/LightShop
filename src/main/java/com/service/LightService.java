package com.service;

import com.dao.LightDAO;
import com.entity.*;
import com.tools.ColorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fuxi on 2017/5/2.
 */
@Service
@Transactional
public class LightService {

    @Autowired
    LightDAO lightDAO;

    //获取所有灯饰
    public List<Light> getLights(){
       return lightDAO.getLights();

    }

    //获取灯饰详情
    public Light getLightById(int lightId){
        return lightDAO.getLightById(lightId);
    }

    //增加灯饰
    public void addLight(Light light){
        light.setClick(0);
        light.setSale(0);
        light.setStore(0);
        lightDAO.addLight(light);
    }

    //删除灯饰
    public void deleteLightById(int lightId){
            lightDAO.deleteLightById(lightId);
    }

    //修改灯饰
    public void updateLight(Light light){
        lightDAO.updateLight(light);
    }
    public void updatePhoto(Integer imageNumber,Integer lightId,String path){
        Light light=this.getLightById(lightId);
        if(imageNumber==1)
            light.setImage1(path);
        else if(imageNumber==2)
            light.setImage2(path);
        else if(imageNumber==3)
            light.setImage3(path);
        this.updateLight(light);
    }
    public List<Map> getBrandsMap(List<Brand> brands){
        List list=new ArrayList();
        for(Brand brand:brands){
            HashMap map=new HashMap();
            map.put("value",lightDAO.getBrandSale(brand.getBrandId()));
            map.put("label",brand.getBrandName());
            map.put("color", ColorUtil.ranColor());
            list.add(map);
        }
        return list;
    }
    public List<Map> getCatagoryMap(List<Catagory> catagories){
        List list=new ArrayList();
        for(Catagory catagory:catagories){
            HashMap map=new HashMap();
            map.put("value",lightDAO.getCatagorySale(catagory.getCatagoryId()));
            map.put("label",catagory.getCatagoryName());
            map.put("color", ColorUtil.ranColor());
            list.add(map);
        }
        return list;
    }
    public List<Map> getStyleMap(List<Style> styles){
        List list=new ArrayList();
        for(Style style:styles){
            HashMap map=new HashMap();
            map.put("value",lightDAO.getStyleSale(style.getStyleId()));
            map.put("label",style.getStyleName());
            map.put("color", ColorUtil.ranColor());
            list.add(map);
        }
        return list;
    }
    public List<Map> getSutffMap(List<Stuff> stuffs){
        List list=new ArrayList();
        for(Stuff stuff:stuffs){
            HashMap map=new HashMap();
            map.put("value",lightDAO.getCatagorySale(stuff.getStuffId()));
            map.put("label",stuff.getStuffName());
            map.put("color", ColorUtil.ranColor());
            list.add(map);
        }
        return list;
    }
    public List<Map> getLocateMap(List<Locate> locates){
        List list=new ArrayList();
        for(Locate locate:locates){
            HashMap map=new HashMap();
            map.put("value",lightDAO.getLocateSale(locate.getLocateId()));
            map.put("label",locate.getName());
            map.put("color", ColorUtil.ranColor());
            list.add(map);
        }
        return list;
    }
}
