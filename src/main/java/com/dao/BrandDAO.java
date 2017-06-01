package com.dao;

import com.entity.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Repository
public class BrandDAO {

    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    //add Brand
    public void addBrand(Brand brand){
        this.getSession().save(brand);
    }

    //delete Brand
    public boolean deleteBrand(Brand brand){
        try {
            this.getSession().delete(brand);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //update Brand
    public boolean updateBrand(Brand brand){
        try {
            this.getSession().update(brand);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
