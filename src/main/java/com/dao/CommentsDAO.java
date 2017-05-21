package com.dao;

import com.entity.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Fuxi on 2017/5/21.
 */
@Repository
public class CommentsDAO {

    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //添加评价
    public void addComment(Comments comments){
        this.getSession().save(comments);
    }
}
