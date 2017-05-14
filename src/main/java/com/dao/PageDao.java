package com.dao;

import com.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AgZou on 2017/5/4.
 */
@Repository
public class PageDao {
@Resource private SessionFactory sessionFactory;
private Session getSession(){
    return this.sessionFactory.getCurrentSession();
}
public Page getPage(){
    return (Page) this.getSession().createQuery("from Page where id = 1").uniqueResult();
}
public List<Brand> getBrands(){
    return this.getSession().createQuery("from Brand").getResultList();
}
public List<Style> getStyles(){
    return this.getSession().createQuery("from Style ").getResultList();
}
public List<Stuff> getStuffs(){
    return this.getSession().createQuery("from Stuff ").getResultList();
}
public List<Locate> getLocates(){
    return this.getSession().createQuery("from Locate ").getResultList();
}
public List<Catagory> getCatagorys(){
    return this.getSession().createQuery("from Catagory ").getResultList();
}
}
