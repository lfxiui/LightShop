package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
@Table(name = "userroles")
public class Userroles {
    private Integer id;
    private String name;
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
    @Column(name = "Name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userroles userroles = (Userroles) o;

        if (id != null ? !id.equals(userroles.id) : userroles.id != null) return false;
        if (name != null ? !name.equals(userroles.name) : userroles.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userrolesByUserRoleId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
