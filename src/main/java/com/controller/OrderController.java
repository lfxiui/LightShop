package com.controller;

import com.entity.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/13.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //test
    @RequestMapping("/test")
    public String test(){
        return "newOrder";
    }
    //获取所有订单
    public List<Orders> getOrdersById(int userId){
        return null;
    }

    //添加订单
    @RequestMapping("/addOrder")
    public String addOrder(@RequestParam(value = "checkbox") Integer[] checkbox, Orders orders,String s_province,String s_city,String s_county){
        int userId = 1;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String ordersId = df.format(new Date()) + String.valueOf(userId);
        orders.setOrdersId(ordersId);
        orders.setOrderStateId(1);
        orders.setUserId(userId);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        orders.setDate(ts);
        orders.setAddress(s_province+s_city+s_county+orders.getAddress());
        orderService.addOrder(orders);
        int n = checkbox.length;
        if (checkbox[0] == 0) n++;
        for (int i = 0 ; i < n ; i++){
            if (checkbox[i] > 0){
                addOrderLight(ordersId,checkbox[i]);
            }
        }
        return "newOrder";
    }

    //订单中的商品
    public void addOrderLight(String orderId,int shopCartId){
        orderService.addOrderLight(orderId,shopCartId);
    }
}
