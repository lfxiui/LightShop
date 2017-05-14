package com.service;

import com.dao.OrderDAO;
import com.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Fuxi on 2017/5/13.
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDAO orderDAO;
    //获取所有订单
    public List<Orders> getOrdersById(int userId){
        return orderDAO.getOrdersById(userId);
    }

    //添加订单
    public void addOrder(Orders orders){
        orderDAO.addOrder(orders);
    }

    //订单中的商品
    public void addOrderLight(String orderId, int myshopcartId){
        orderDAO.addOrderLight(orderId,myshopcartId);
    }
}
