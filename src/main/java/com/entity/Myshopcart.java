package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Myshopcart {
    private Integer shopCartId;
    private Integer lightId;
    private Integer userId;
    private Timestamp addDate;
    private Integer quantiy;
    private Light lightByLightId;
    private User userByUserId;

    @Id
    @Column(name = "ShopCartId", nullable = false)
    public Integer getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Integer shopCartId) {
        this.shopCartId = shopCartId;
    }

    @Basic
    @Column(name = "LightId", nullable = false)
    public Integer getLightId() {
        return lightId;
    }

    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    @Basic
    @Column(name = "UserId", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "AddDate", nullable = false)
    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    @Basic
    @Column(name = "Quantiy", nullable = false)
    public Integer getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Integer quantiy) {
        this.quantiy = quantiy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Myshopcart that = (Myshopcart) o;

        if (shopCartId != null ? !shopCartId.equals(that.shopCartId) : that.shopCartId != null) return false;
        if (lightId != null ? !lightId.equals(that.lightId) : that.lightId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
        if (quantiy != null ? !quantiy.equals(that.quantiy) : that.quantiy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopCartId != null ? shopCartId.hashCode() : 0;
        result = 31 * result + (lightId != null ? lightId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        result = 31 * result + (quantiy != null ? quantiy.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LightId", referencedColumnName = "LightId", nullable = false,insertable = false,updatable = false)
    public Light getLightByLightId() {
        return lightByLightId;
    }

    public void setLightByLightId(Light lightByLightId) {
        this.lightByLightId = lightByLightId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false,insertable = false,updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
