package com.service;

import com.dao.LocateDAO;
import com.entity.Locate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Service
@Transactional
public class LocateService {
    @Autowired
    LocateDAO locateDAO;
    //add locate
    public void addLocate(Locate locate){
locateDAO.addLocate(locate);
    }

    //deleteLocate
    public boolean deleteLocate(Locate locate){
return locateDAO.deleteLocate(locate);
    }

    //update locate
    public boolean updateLocate(Locate locate){
return locateDAO.updateLocate(locate);
    }
}
