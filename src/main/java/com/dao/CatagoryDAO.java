package com.dao;

import com.entity.Catagory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Repository
public class CatagoryDAO {
    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    //add catagory
    public void addCatagory(Catagory catagory){
        this.getSession().save(catagory);
    }

    //delete catagory
    public boolean deleteCataGory(Catagory catagory){
        try {
            this.getSession().delete(catagory);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //update catagory
    public boolean updateCataGory(Catagory catagory){
        try {
            this.getSession().update(catagory);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
