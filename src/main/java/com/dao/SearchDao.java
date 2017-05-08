package com.dao;

import com.entity.Light;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AgZou on 2017/5/8.
 */
@Repository
public class SearchDao {
    @Resource private SessionFactory sessionFactory;
    private Session getSession(){
        return  this.sessionFactory.getCurrentSession();
    }
    public List<Light> getLightsByAll(String flag){
        Query query=this.getSession().createQuery("from Light where name like ? or description like ?");
        query.setParameter(0,"%"+flag+"%");
        query.setParameter(1,"%"+flag+"%");
        return  query.getResultList();
    }
}
