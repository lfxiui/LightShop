package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AgZou on 2017/5/1.
 */
@Repository
public class StatisticsDao {
    @Resource
    private SessionFactory sessionFactory;
    private Session getSession(){
     return    this.sessionFactory.getCurrentSession();
    }
    public List getStatisticsList(){
        return  this.getSession().createQuery("from Statistics ").list();
    }
}
