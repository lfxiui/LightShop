package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Orders {
    private String ordersId;
    private Integer userId;
    private Double totalPrice;
    private Timestamp date;
    private Integer orderStateId;
    private String receiveName;
    private String receivePhone;
    private String address;
    private String email;
    private String postalCode;
    private String postType;
    private String paymentType;
    private Integer postFee;
    @JsonIgnore
    private Collection<Orderlight> orderlightsByOrdersId;
    private User userByUserId;
    @JsonIgnore
    private Orderstates orderstatesByOrderStateId;

    @Id
    @Column(name = "OrdersId", nullable = true, length = 18)
    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    @Basic
    @Column(name = "UserId", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "TotalPrice", nullable = false, precision = 0)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "Date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "OrderStateId", nullable = false)
    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }

    @Basic
    @Column(name = "ReceiveName", nullable = false, length = 20)
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    @Basic
    @Column(name = "ReceivePhone", nullable = false, length = 11)
    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    @Basic
    @Column(name = "Address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PostalCode", nullable = true, length = 6)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "PostType", nullable = false, length = 20)
    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Basic
    @Column(name = "PaymentType", nullable = true, length = 20)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Basic
    @Column(name = "PostFee", nullable = false)
    public Integer getPostFee() {
        return postFee;
    }

    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (ordersId != null ? !ordersId.equals(orders.ordersId) : orders.ordersId != null) return false;
        if (userId != null ? !userId.equals(orders.userId) : orders.userId != null) return false;
        if (totalPrice != null ? !totalPrice.equals(orders.totalPrice) : orders.totalPrice != null) return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;
        if (orderStateId != null ? !orderStateId.equals(orders.orderStateId) : orders.orderStateId != null)
            return false;
        if (receiveName != null ? !receiveName.equals(orders.receiveName) : orders.receiveName != null) return false;
        if (receivePhone != null ? !receivePhone.equals(orders.receivePhone) : orders.receivePhone != null)
            return false;
        if (address != null ? !address.equals(orders.address) : orders.address != null) return false;
        if (email != null ? !email.equals(orders.email) : orders.email != null) return false;
        if (postalCode != null ? !postalCode.equals(orders.postalCode) : orders.postalCode != null) return false;
        if (postType != null ? !postType.equals(orders.postType) : orders.postType != null) return false;
        if (paymentType != null ? !paymentType.equals(orders.paymentType) : orders.paymentType != null) return false;
        if (postFee != null ? !postFee.equals(orders.postFee) : orders.postFee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ordersId != null ? ordersId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (orderStateId != null ? orderStateId.hashCode() : 0);
        result = 31 * result + (receiveName != null ? receiveName.hashCode() : 0);
        result = 31 * result + (receivePhone != null ? receivePhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (postType != null ? postType.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (postFee != null ? postFee.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<Orderlight> getOrderlightsByOrdersId() {
        return orderlightsByOrdersId;
    }

    public void setOrderlightsByOrdersId(Collection<Orderlight> orderlightsByOrdersId) {
        this.orderlightsByOrdersId = orderlightsByOrdersId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false,insertable = false,updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "OrderStateId", referencedColumnName = "Id", nullable = false,insertable = false,updatable = false)
    public Orderstates getOrderstatesByOrderStateId() {
        return orderstatesByOrderStateId;
    }

    public void setOrderstatesByOrderStateId(Orderstates orderstatesByOrderStateId) {
        this.orderstatesByOrderStateId = orderstatesByOrderStateId;
    }
}
