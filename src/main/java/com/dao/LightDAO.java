package com.dao;

import com.entity.Light;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/2.
 */
@Repository
public class LightDAO {

    @Resource private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //获取所有灯饰
    public List<Light> getLights(){
        return this.getSession().createQuery("from Light").list();
    }

    //获取灯饰详情
    public Light getLightById(int lightId){
        return (Light) this.getSession().createQuery("from Light where lightId=?").setParameter(0, lightId).uniqueResult();
    }

    //增加灯饰
    public void addLight(Light light){
            this.getSession().save(light);
    }

    //删除灯饰
    public void deleteLightById(int lightId){
            this.getSession().delete(getLightById(lightId));
    }

    //修改灯饰
    public void updateLight(Light light){
        this.getSession().update(light);
    }
}
