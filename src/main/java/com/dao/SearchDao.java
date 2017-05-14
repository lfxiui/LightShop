package com.dao;

import com.entity.Light;
import com.entity.Page;
import com.mysql.cj.mysqlx.protobuf.MysqlxCrud;
import com.tools.PageMessage;
import com.tools.PageUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
    public PageMessage getLights(int everyPage,int currentPage){
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());

    }

    public PageMessage getLightsByAll(HashMap map, List<Integer> checkbox,int everyPage,int currentPage,String flag) {
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox.size() > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
        criteria.add(Restrictions.allEq(map));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
      return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());

    }

    public PageMessage getLightsByForm(HashMap map, String flag, Integer[] checkbox ,int everyPage,int currentPage) {
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox != null && checkbox.length > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
      criteria.add(Restrictions.allEq(map));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }

    public PageMessage getLightsByType(String name, Integer id,int everyPage,int currentPage) {
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.eq(name, id)).list();
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }

    public PageMessage getLightsBySort1(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox.size() > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
        criteria.add(Restrictions.allEq(map));
        criteria.addOrder(Order.asc("price"));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }
    public PageMessage getLightsBySort2(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox.size() > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
        criteria.add(Restrictions.allEq(map));
     criteria.addOrder(Order.desc("price"));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }
    public PageMessage getLightsBySort3(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox.size() > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
        criteria.add(Restrictions.allEq(map));
       criteria.addOrder(Order.desc("sale"));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }
    public PageMessage getLightsBySort4(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        Criteria criteria = this.getSession().createCriteria(Light.class);
        criteria.add(Restrictions.or(Restrictions.like("name", flag, MatchMode.ANYWHERE), Restrictions.like("description", flag, MatchMode.ANYWHERE)));
        if (checkbox.size() > 0)
            criteria.add(Restrictions.in("brandId", checkbox));
        criteria.add(Restrictions.allEq(map));
        criteria.addOrder(Order.desc("store"));
        criteria.setProjection(Projections.rowCount());
        int totalCount = Integer.valueOf(criteria.uniqueResult().toString());
        criteria.setProjection(null);
        criteria.setFirstResult((everyPage) * (currentPage - 1));
        criteria.setMaxResults(everyPage);
        return   PageUtil.createPage(everyPage, totalCount, currentPage, criteria.list());
    }
}
