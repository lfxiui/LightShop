package com.dao;

import com.entity.Stuff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Repository
public class StuffDAO {
    @Resource
    SessionFactory sessionFactory;
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    //add stuff
    public void addStuff(Stuff stuff){
        this.getSession().save(stuff);
    }
    //delete stuff
    public boolean deleteStuff(Stuff stuff){
        try {
            this.getSession().delete(stuff);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //updateStuff
    public boolean updateStuff(Stuff stuff){
        try {
            this.getSession().update(stuff);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
