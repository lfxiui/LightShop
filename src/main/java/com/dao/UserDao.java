package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by AgZou on 2017/5/13.
 */
@Repository
public class UserDao {
    @Resource private SessionFactory sessionFactory;
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public User getUser(Integer userId){
        return (User) getSession().createQuery("from User where userId=?").setParameter(0,userId).uniqueResult();
    }
    public int updateUser(String flag,String v,Integer userId){
        String hql="update User set "+flag+" = '"+v+"' where userId = "+userId;
        System.out.println(hql);
       return getSession().createQuery(hql).executeUpdate();
    }
    public User getUserByLoginId(String loginId){
        return (User) getSession().createQuery("from User where loginId=?").setParameter(0,loginId).uniqueResult();
    }
    public void update(User user){
        this.getSession().update(user);
    }
}
