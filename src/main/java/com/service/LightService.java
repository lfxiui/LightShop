package com.service;

import com.dao.LightDAO;
import com.entity.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
