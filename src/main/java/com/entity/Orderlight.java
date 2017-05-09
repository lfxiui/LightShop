package com.entity;

import javax.persistence.*;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Orderlight {
    private Integer id;
    private Integer orderId;
    private Integer lightId;
    private Integer quantity;
    private Orders ordersByOrderId;
    private Light lightByLightId;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OrderId", nullable = false, length = 18)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
    @Column(name = "Quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderlight that = (Orderlight) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (lightId != null ? !lightId.equals(that.lightId) : that.lightId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (lightId != null ? lightId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "OrderId", referencedColumnName = "OrdersId", nullable = false,insertable = false,updatable = false)
    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "LightId", referencedColumnName = "LightId", nullable = false,insertable = false,updatable = false)
    public Light getLightByLightId() {
        return lightByLightId;
    }

    public void setLightByLightId(Light lightByLightId) {
        this.lightByLightId = lightByLightId;
    }
}
