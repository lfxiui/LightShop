package com.service;

import com.dao.BrandDAO;
import com.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Fuxi on 2017/5/31.
 */
@Service
@Transactional
public class BrandService {

    @Autowired
    BrandDAO brandDAO;
    //add Brand
    public void addBrand(Brand brand){
        brandDAO.addBrand(brand);
    }

    //delete Brand
    public boolean deleteBrand(Brand brand){
        return brandDAO.deleteBrand(brand);
    }

    //update Brand
    public boolean updateBrand(Brand brand){
        return brandDAO.updateBrand(brand);
    }
}
