package com.service;

import com.dao.StuffDAO;
import com.entity.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Service
@Transactional
public class StuffService {
    @Autowired
    StuffDAO stuffDAO;
    //add stuff
    public void addStuff(Stuff stuff){
stuffDAO.addStuff(stuff);
    }
    //delete stuff
    public boolean deleteStuff(Stuff stuff){
return stuffDAO.deleteStuff(stuff);
    }
    //updateStuff
    public boolean updateStuff(Stuff stuff){
return  stuffDAO.updateStuff(stuff);
    }
}
