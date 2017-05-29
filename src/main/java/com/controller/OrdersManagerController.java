package com.controller;

import com.entity.Orders;
import com.entity.Orderstates;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Fuxi on 2017/5/26.
 */
@Controller
@RequestMapping("/ordersManager")
public class OrdersManagerController {

    @Autowired
    OrderService orderService;

    //show
    @RequestMapping("/show")
    public String show(){
        return "ordersManager";
    }

    //show
    @RequestMapping("/orderStates")
    public String orderStates(){
        return "orderStates";
    }

    //ordersList
    @RequestMapping("/ordersList")
    @ResponseBody
    public List<Orders> ordersList(){
        return orderService.ordersList();
    }

    //订单状态list
    @RequestMapping("/orderstatesList")
    @ResponseBody
    public List<Orderstates> orderstatesList(){
        return orderService.orderstatesList();
    }

    //更新订单状态
    @RequestMapping("/updateOrders")
    @ResponseBody
    public String updateDept(@RequestBody Orders orders) {
        orderService.updateOrders(orders);
        return "success";
    }

    //
    @RequestMapping("/addOrderStates")
    public String addOrderStates(Orderstates orderstates){
        orderService.addOrderStates(orderstates);
        return "orderStates";
    }

    @RequestMapping("/deleteOrderStates")
    @ResponseBody
    public String deleteOrderStates(@RequestBody Orderstates orderstates){
        orderService.deleteOrderStates(orderstates);
        return "orderStates";
    }
    @RequestMapping("/updateOrderStates")
    @ResponseBody
    public String updateOrderStates(@RequestBody Orderstates orderstates){
        orderService.updateOrderStates(orderstates);
        return "orderStates";
    }
}
