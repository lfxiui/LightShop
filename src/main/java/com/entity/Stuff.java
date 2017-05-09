package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Stuff {
    private Integer stuffId;
    private String stuffName;
    private Collection<Light> lightsByStuffId;

    @Id
    @Column(name = "StuffId", nullable = false)
    public Integer getStuffId() {
        return stuffId;
    }

    public void setStuffId(Integer stuffId) {
        this.stuffId = stuffId;
    }

    @Basic
    @Column(name = "StuffName", nullable = false, length = 20)
    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stuff stuff = (Stuff) o;

        if (stuffId != null ? !stuffId.equals(stuff.stuffId) : stuff.stuffId != null) return false;
        if (stuffName != null ? !stuffName.equals(stuff.stuffName) : stuff.stuffName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stuffId != null ? stuffId.hashCode() : 0;
        result = 31 * result + (stuffName != null ? stuffName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stuffByStuffId")
    public Collection<Light> getLightsByStuffId() {
        return lightsByStuffId;
    }

    public void setLightsByStuffId(Collection<Light> lightsByStuffId) {
        this.lightsByStuffId = lightsByStuffId;
    }
}
