package com.service;

import com.dao.CatagoryDAO;
import com.entity.Catagory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Service
@Transactional
public class CatagoryService {

    @Autowired
    CatagoryDAO catagoryDAO;
    //add catagory
    public void addCatagory(Catagory catagory){
        catagoryDAO.addCatagory(catagory);
    }

    //delete catagory
    public boolean deleteCataGory(Catagory catagory){
        return catagoryDAO.deleteCataGory(catagory);
    }

    //update catagory
    public boolean updateCataGory(Catagory catagory){
        return catagoryDAO.updateCataGory(catagory);
    }
}
