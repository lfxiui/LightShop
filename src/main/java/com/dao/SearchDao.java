package com.dao;

import com.entity.Light;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public List<Light> getLightsByAll(HashMap map,List<Integer> checkbox){
    Criteria criteria=this.getSession().createCriteria(Light.class);if(checkbox.size()>0)
            criteria.add(Restrictions.in("brandId",checkbox));
  //  criteria.add(Restrictions.or(Restrictions.like("description",flag,MatchMode.ANYWHERE),Restrictions.like("name",flag, MatchMode.ANYWHERE)));
    return criteria.add(Restrictions.allEq(map)).list();
}
public List<Light> getLightsByForm(HashMap map,String flag,Integer[] checkbox){
    Criteria criteria=this.getSession().createCriteria(Light.class);
    criteria.add(Restrictions.or(Restrictions.like("description",flag,MatchMode.ANYWHERE),Restrictions.like("name",flag, MatchMode.ANYWHERE)));
    if(checkbox!=null&&checkbox.length>0)
    criteria.add(Restrictions.in("brandId",checkbox));
    return criteria.add(Restrictions.allEq(map)).list();
}
public List<Light> getLightsByType(String name,Integer id){
    Criteria criteria=this.getSession().createCriteria(Light.class);
    return criteria.add(Restrictions.eq(name,id)).list();
}
}
