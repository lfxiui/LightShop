package com.service;

import com.dao.MyShopCartDAO;
import com.entity.Myshopcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Fuxi on 2017/5/6.
 */
@Service
@Transactional
public class MyShopCartService {
    @Autowired
    MyShopCartDAO myShopCartDAO;

    //获得购物车信息
    public List<Myshopcart> getMyShopCartById(int userId)
    {
        return myShopCartDAO.getMyShopCartById(userId);
    }

    //添加商品
    public void addLight(int userId,int lightId,int quantity){
        myShopCartDAO.addLight(userId,lightId,quantity);
    }

    //获取最新库存
    public int getQuantity(int lightId){
        return myShopCartDAO.getQuantity(lightId);
    }

    //修改数量
    public void updateQuantity(int userId,int lightId,int quantitly){

    }

    //删除商品
    public void deleteLightById(int userId,int lightId){
        myShopCartDAO.deleteLightById(userId,lightId);
    }
}
