package com.dao;

import com.entity.Locate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Repository
public class LocateDAO {
    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    //add locate
    public void addLocate(Locate locate){
        this.getSession().save(locate);
    }

    //deleteLocate
    public boolean deleteLocate(Locate locate){
        try {
            this.getSession().delete(locate);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //update locate
    public boolean updateLocate(Locate locate){
        try {
            this.getSession().update(locate);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
