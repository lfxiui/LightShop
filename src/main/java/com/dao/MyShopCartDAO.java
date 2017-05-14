package com.dao;

import com.entity.Light;
import com.entity.Myshopcart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Fuxi on 2017/5/6.
 */
@Repository
public class MyShopCartDAO {

    @Resource
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //获得购物车信息
    public List<Myshopcart> getMyShopCartById(int userId){
        return this.getSession().createQuery("from Myshopcart where userId=?").setParameter(0, userId).getResultList();
    }

    //添加商品
   public void addLight(int userId,int lightId,int quantity){
        if ((Myshopcart)this.getSession().createQuery("from Myshopcart where userId=? and lightId=?").setParameter(0,userId).setParameter(1,lightId).uniqueResult()==null){
            Myshopcart myshopcart = new Myshopcart();
            myshopcart.setQuantiy(quantity);
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            myshopcart.setAddDate(ts);
            myshopcart.setLightId(lightId);
            myshopcart.setUserId(userId);
            this.getSession().save(myshopcart);
        }else {
            Myshopcart myshopcart2 = (Myshopcart)this.getSession().createQuery("from Myshopcart where userId=? and lightId=?").setParameter(0,userId).setParameter(1,lightId).uniqueResult();
            myshopcart2.setQuantiy(myshopcart2.getQuantiy()+quantity);
            this.getSession().update(myshopcart2);
        }
        this.updateQuantity(lightId,-quantity);
   }

   //更新库存
    public void updateQuantity(int lightId,int quantity){
        Light light = (Light) this.getSession().createQuery("from Light where lightId=?").setParameter(0, lightId).uniqueResult();
        light.setQuantity(light.getQuantity() + quantity);
        this.getSession().update(light);
    }

   //获取最新库存
    public int getQuantity(int lightId){
       Light light=(Light)this.getSession().createQuery("from Light where lightId=?").setParameter(0,lightId).uniqueResult();
       return light.getQuantity();
    }

   //修改数量
    public void updateQuantity(int userId,int lightId,int quantitly){

    }

    //删除商品
    public void deleteLightById(int userId,int lightId){
        Myshopcart myshopcart = (Myshopcart) this.getSession().createQuery("FROM Myshopcart where userId=? and lightId=?").setParameter(0, userId).setParameter(1,lightId).uniqueResult();
        if (myshopcart==null) return;
        this.updateQuantity(lightId,myshopcart.getQuantiy());
        this.getSession().delete(myshopcart);
    }

}
