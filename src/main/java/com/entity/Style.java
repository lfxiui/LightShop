package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
public class Style {
    private Integer styleId;
    private String styleName;
    private Collection<Light> lightsByStyleId;

    @Id
    @Column(name = "StyleId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        Style style = (Style) o;

        if (styleId != null ? !styleId.equals(style.styleId) : style.styleId != null) return false;
        if (styleName != null ? !styleName.equals(style.styleName) : style.styleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = styleId != null ? styleId.hashCode() : 0;
        result = 31 * result + (styleName != null ? styleName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "styleByStyleId")
    @JsonIgnore
    public Collection<Light> getLightsByStyleId() {
        return lightsByStyleId;
    }

    public void setLightsByStyleId(Collection<Light> lightsByStyleId) {
        this.lightsByStyleId = lightsByStyleId;
    }
}
