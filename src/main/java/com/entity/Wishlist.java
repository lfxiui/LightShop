package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by AgZou on 2017/5/4.
 */
@Entity
public class Wishlist {
    private Integer wishListId;
    private Integer lightId;
    private Integer userId;
    private Timestamp storeDate;
    private Light lightByLightId;
    private User userByUserId;

    @Id
    @Column(name = "WishListId", nullable = false)
    public Integer getWishListId() {
        return wishListId;
    }

    public void setWishListId(Integer wishListId) {
        this.wishListId = wishListId;
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
    @Column(name = "StoreDate", nullable = false)
    public Timestamp getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Timestamp storeDate) {
        this.storeDate = storeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wishlist wishlist = (Wishlist) o;

        if (wishListId != null ? !wishListId.equals(wishlist.wishListId) : wishlist.wishListId != null) return false;
        if (lightId != null ? !lightId.equals(wishlist.lightId) : wishlist.lightId != null) return false;
        if (userId != null ? !userId.equals(wishlist.userId) : wishlist.userId != null) return false;
        if (storeDate != null ? !storeDate.equals(wishlist.storeDate) : wishlist.storeDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wishListId != null ? wishListId.hashCode() : 0;
        result = 31 * result + (lightId != null ? lightId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (storeDate != null ? storeDate.hashCode() : 0);
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
