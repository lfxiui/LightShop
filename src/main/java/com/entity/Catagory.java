package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/4.
 */
@Entity
public class Catagory {
    private Integer catagoryId;
    private String catagoryName;
    private Collection<Light> lightsByCatagoryId;

    @Id
    @Column(name = "CatagoryId", nullable = false)
    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    @Basic
    @Column(name = "CatagoryName", nullable = false, length = 20)
    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catagory catagory = (Catagory) o;

        if (catagoryId != null ? !catagoryId.equals(catagory.catagoryId) : catagory.catagoryId != null) return false;
        if (catagoryName != null ? !catagoryName.equals(catagory.catagoryName) : catagory.catagoryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catagoryId != null ? catagoryId.hashCode() : 0;
        result = 31 * result + (catagoryName != null ? catagoryName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "catagoryByCatagoryId")
    public Collection<Light> getLightsByCatagoryId() {
        return lightsByCatagoryId;
    }

    public void setLightsByCatagoryId(Collection<Light> lightsByCatagoryId) {
        this.lightsByCatagoryId = lightsByCatagoryId;
    }
}
