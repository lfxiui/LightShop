package com.dao;

import com.entity.Style;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Repository
public class StyleDAO {
    @Resource
    SessionFactory sessionFactory;
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    //addStyle
    public void addStyle(Style style){
        this.getSession().save(style);
    }
    public boolean deleteStyle(Style style){
        try {
            this.getSession().delete(style);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public boolean updateStyle(Style style){
        try {
            this.getSession().update(style);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
