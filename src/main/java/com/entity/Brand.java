package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
@Table(name = "brand")
public class Brand {
    private Integer brandId;
    private String brandName;
    @JsonIgnore
    private Collection<Light> lightsByBrandId;

    @Id
    @Column(name = "BrandId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "BrandName", nullable = false, length = 20)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (brandId != null ? !brandId.equals(brand.brandId) : brand.brandId != null) return false;
        if (brandName != null ? !brandName.equals(brand.brandName) : brand.brandName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brandId != null ? brandId.hashCode() : 0;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "brandByBrandId")
    public Collection<Light> getLightsByBrandId() {
        return lightsByBrandId;
    }

    public void setLightsByBrandId(Collection<Light> lightsByBrandId) {
        this.lightsByBrandId = lightsByBrandId;
    }
}
