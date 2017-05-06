package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/4.
 */
@Entity
public class User {
    private Integer userId;
    private String userName;
    private String address;
    private String postalCode;
    private String phone;
    private String email;
    private String gender;
    private Integer userRoleId;
    private Integer userStateId;
    private String loginId;
    private String loginPwd;
    private Timestamp lastLoginTime;
    private Collection<Comments> commentsByUserId;
    private Collection<Myshopcart> myshopcartsByUserId;
    private Collection<Orders> ordersByUserId;
    private Userroles userrolesByUserRoleId;
    private Userstates userstatesByUserStateId;
    private Collection<Wishlist> wishlistsByUserId;

    @Id
    @Column(name = "UserId", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserName", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "Phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "Gender", nullable = false, length = 4)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "UserRoleId", nullable = false)
    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "UserStateId", nullable = false)
    public Integer getUserStateId() {
        return userStateId;
    }

    public void setUserStateId(Integer userStateId) {
        this.userStateId = userStateId;
    }

    @Basic
    @Column(name = "LoginId", nullable = false, length = 50)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "LoginPwd", nullable = false, length = 50)
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Basic
    @Column(name = "LastLoginTime", nullable = true)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (postalCode != null ? !postalCode.equals(user.postalCode) : user.postalCode != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (userRoleId != null ? !userRoleId.equals(user.userRoleId) : user.userRoleId != null) return false;
        if (userStateId != null ? !userStateId.equals(user.userStateId) : user.userStateId != null) return false;
        if (loginId != null ? !loginId.equals(user.loginId) : user.loginId != null) return false;
        if (loginPwd != null ? !loginPwd.equals(user.loginPwd) : user.loginPwd != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (userRoleId != null ? userRoleId.hashCode() : 0);
        result = 31 * result + (userStateId != null ? userStateId.hashCode() : 0);
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (loginPwd != null ? loginPwd.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Comments> getCommentsByUserId() {
        return commentsByUserId;
    }

    public void setCommentsByUserId(Collection<Comments> commentsByUserId) {
        this.commentsByUserId = commentsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Myshopcart> getMyshopcartsByUserId() {
        return myshopcartsByUserId;
    }

    public void setMyshopcartsByUserId(Collection<Myshopcart> myshopcartsByUserId) {
        this.myshopcartsByUserId = myshopcartsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Orders> getOrdersByUserId() {
        return ordersByUserId;
    }

    public void setOrdersByUserId(Collection<Orders> ordersByUserId) {
        this.ordersByUserId = ordersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "UserRoleId", referencedColumnName = "Id", nullable = false,insertable = false,updatable = false)
    public Userroles getUserrolesByUserRoleId() {
        return userrolesByUserRoleId;
    }

    public void setUserrolesByUserRoleId(Userroles userrolesByUserRoleId) {
        this.userrolesByUserRoleId = userrolesByUserRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "UserStateId", referencedColumnName = "Id", nullable = false,insertable = false,updatable = false)
    public Userstates getUserstatesByUserStateId() {
        return userstatesByUserStateId;
    }

    public void setUserstatesByUserStateId(Userstates userstatesByUserStateId) {
        this.userstatesByUserStateId = userstatesByUserStateId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Wishlist> getWishlistsByUserId() {
        return wishlistsByUserId;
    }

    public void setWishlistsByUserId(Collection<Wishlist> wishlistsByUserId) {
        this.wishlistsByUserId = wishlistsByUserId;
    }
}
