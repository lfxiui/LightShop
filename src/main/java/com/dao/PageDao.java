package com.dao;

import com.entity.Page;
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
}
