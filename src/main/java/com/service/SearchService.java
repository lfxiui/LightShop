package com.service;

import com.dao.SearchDao;
import com.entity.Light;
import com.tools.PageMessage;
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
    public PageMessage getLightsByAll(HashMap map, List<Integer> checkbox,int everyPage,int currentPage,String flag){
        return searchDao.getLightsByAll(map,checkbox,everyPage,currentPage,flag);
    }
    public PageMessage getLightsByFrom(HashMap map,String flag,Integer[]checkbox,int everyPage,int currentPage){
        return  searchDao.getLightsByForm(map,flag,checkbox,everyPage,currentPage);
    }
    public PageMessage getLightsByType(String name,Integer id,int everyPage,int currentPage){
        return  searchDao.getLightsByType(name,id,everyPage,currentPage);
    }
    public PageMessage getLightBySort1(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        return searchDao.getLightsBySort1(map,checkbox,flag,everyPage,currentPage);
    }
    public PageMessage getLightBySort2(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        return searchDao.getLightsBySort2(map,checkbox,flag,everyPage,currentPage);
    }
    public PageMessage getLightBySort3(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        return searchDao.getLightsBySort3(map,checkbox,flag,everyPage,currentPage);
    }
    public PageMessage getLightBySort4(HashMap map,List<Integer> checkbox,String flag,int everyPage,int currentPage){
        return searchDao.getLightsBySort4(map,checkbox,flag,everyPage,currentPage);
    }
    public  PageMessage getLights(int everyPage,int currentPage){
        return searchDao.getLights(everyPage,currentPage);
    }
}
