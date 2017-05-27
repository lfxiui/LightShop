package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Locate {
    private Integer locateId;
    private String name;
    @JsonIgnore
    private Collection<Light> lightsByLocateId;

    @Id
    @Column(name = "LocateId", nullable = false)
    public Integer getLocateId() {
        return locateId;
    }

    public void setLocateId(Integer locateId) {
        this.locateId = locateId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
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

        Locate locate = (Locate) o;

        if (locateId != null ? !locateId.equals(locate.locateId) : locate.locateId != null) return false;
        if (name != null ? !name.equals(locate.name) : locate.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locateId != null ? locateId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locateByLocateId")
    public Collection<Light> getLightsByLocateId() {
        return lightsByLocateId;
    }

    public void setLightsByLocateId(Collection<Light> lightsByLocateId) {
        this.lightsByLocateId = lightsByLocateId;
    }
}
