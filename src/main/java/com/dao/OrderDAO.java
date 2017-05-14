package com.dao;

import com.entity.Myshopcart;
import com.entity.Orderlight;
import com.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/13.
 */
@Repository
public class OrderDAO {
    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();    }

    //获取所有订单
    public List<Orders> getOrdersById(int userId){
        return null;
    }

    //添加订单
    public void addOrder(Orders orders){
        this.getSession().save(orders);
    }

    //订单中的商品
    public void addOrderLight(String orderId, int myShopCartId){
        Orderlight orderlight = new Orderlight();
        Myshopcart myshopcart = (Myshopcart) this.getSession().createQuery("from Myshopcart where shopCartId=?").setParameter(0,myShopCartId).uniqueResult();
        orderlight.setQuantity(myshopcart.getQuantiy());
        orderlight.setLightId(myshopcart.getLightId());
        orderlight.setOrderId(orderId);
        this.getSession().save(orderlight);
        this.getSession().delete(myshopcart);
    }

}
