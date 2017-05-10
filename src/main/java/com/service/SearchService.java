package com.service;

import com.dao.SearchDao;
import com.entity.Light;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

/**
 * Created by AgZou on 2017/5/9.
 */
@Service
@Transactional
public class SearchService {
    private final SearchDao searchDao;

    @Autowired
    public SearchService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }
    public List<Light> getLightsByAll(HashMap map,List<Integer> checkbox){
        return searchDao.getLightsByAll(map,checkbox);
    }
    public List<Light> getLightsByFrom(HashMap map,String flag,Integer[]checkbox){
        return  searchDao.getLightsByForm(map,flag,checkbox);
    }
    public List<Light> getLightsByType(String name,Integer id){
        return  searchDao.getLightsByType(name,id);
    }
}
