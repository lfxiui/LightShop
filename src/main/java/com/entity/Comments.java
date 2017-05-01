package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by AgZou on 2017/5/1.
 */
@Entity
public class Comments {
    private Integer commentsId;
    private Integer lightId;
    private Integer userId;
    private String comments;
    private Timestamp date;
    private Light lightByLightId;
    private User userByUserId;

    @Id
    @Column(name = "CommentsId", nullable = false)
    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
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
    @Column(name = "Comments", nullable = false, length = 150)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "Date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments1 = (Comments) o;

        if (commentsId != null ? !commentsId.equals(comments1.commentsId) : comments1.commentsId != null) return false;
        if (lightId != null ? !lightId.equals(comments1.lightId) : comments1.lightId != null) return false;
        if (userId != null ? !userId.equals(comments1.userId) : comments1.userId != null) return false;
        if (comments != null ? !comments.equals(comments1.comments) : comments1.comments != null) return false;
        if (date != null ? !date.equals(comments1.date) : comments1.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentsId != null ? commentsId.hashCode() : 0;
        result = 31 * result + (lightId != null ? lightId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LightId", referencedColumnName = "LightId", nullable = false)
    public Light getLightByLightId() {
        return lightByLightId;
    }

    public void setLightByLightId(Light lightByLightId) {
        this.lightByLightId = lightByLightId;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
