package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by AgZou on 2017/5/13.
 */
@Service
@Transactional
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public User getUser(Integer userId){
        return userDao.getUser(userId);
    }
    public int updateUser(String flag,String v,Integer userId){
        return  userDao.updateUser(flag,v,userId);
    }
    public User getUserByLoginId(String loginId){
        User user=userDao.getUserByLoginId(loginId);
        if(user!=null){
            Date date =new Date();
            user.setLastLoginTime(new Timestamp(date.getTime()));
            userDao.update(user);
        }
        return user;
    }
}
