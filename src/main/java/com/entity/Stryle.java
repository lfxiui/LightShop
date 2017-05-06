package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/4.
 */
@Entity
public class Stryle {
    private Integer styleId;
    private String styleName;
    private Collection<Light> lightsByStyleId;

    @Id
    @Column(name = "StyleId", nullable = false)
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    @Basic
    @Column(name = "StyleName", nullable = false, length = 20)
    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stryle stryle = (Stryle) o;

        if (styleId != null ? !styleId.equals(stryle.styleId) : stryle.styleId != null) return false;
        if (styleName != null ? !styleName.equals(stryle.styleName) : stryle.styleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = styleId != null ? styleId.hashCode() : 0;
        result = 31 * result + (styleName != null ? styleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "stryleByStyleId")
    public Collection<Light> getLightsByStyleId() {
        return lightsByStyleId;
    }

    public void setLightsByStyleId(Collection<Light> lightsByStyleId) {
        this.lightsByStyleId = lightsByStyleId;
    }
}
