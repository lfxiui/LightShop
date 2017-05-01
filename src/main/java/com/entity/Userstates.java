package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/1.
 */
@Entity
public class Userstates {
    private Integer id;
    private String nmae;
    private Collection<User> usersById;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Nmae", nullable = false, length = 20)
    public String getNmae() {
        return nmae;
    }

    public void setNmae(String nmae) {
        this.nmae = nmae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userstates that = (Userstates) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nmae != null ? !nmae.equals(that.nmae) : that.nmae != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nmae != null ? nmae.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userstatesByUserStateId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
