package com.dao;

import com.entity.*;
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
    public List<Orders> getOrdersById(int userId , int state){
        if (state == 0){
            return this.getSession().createQuery("from Orders where userId=?").setParameter(0,userId).list();
        }else {
            return this.getSession().createQuery("from Orders where userId=? and orderStateId=?").setParameter(0,userId).setParameter(1,state).list();
        }
    }

    //获取订单信息
    public Orders getOrderById(String orderId , int userId){
        return (Orders) this.getSession().createQuery("from Orders where ordersId=? and userId=?").setParameter(0,orderId).setParameter(1,userId).uniqueResult();
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
        Light light = myshopcart.getLightByLightId();
        light.setSale(light.getSale() + myshopcart.getQuantiy());
        this.getSession().save(orderlight);
        this.getSession().update(light);
        this.getSession().delete(myshopcart);
    }

    //订单管理-获取订单list
    public List<Orders> ordersList(){
        return this.getSession().createQuery("from Orders").list();
    }

    //订单状态list
    public List<Orderstates> orderstatesList(){
        return this.getSession().createQuery("from Orderstates").list();
    }

    public void updateOrders(Orders orders){
        this.getSession().update(orders);
    }

    public void addOrderStates(Orderstates orderstates){
        this.getSession().save(orderstates);
    }

    public void deleteOrderStates(Orderstates orderstates){
        this.getSession().delete(orderstates);
    }

    public void updateOrderStates(Orderstates orderstates){
        this.getSession().update(orderstates);
    }
}
