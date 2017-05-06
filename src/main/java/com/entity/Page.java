package com.entity;

import javax.persistence.*;

/**
 * Created by AgZou on 2017/5/4.
 */
@Entity
public class Page {
    private Integer id;
    private Integer hotSale1;
    private Integer hotSale2;
    private Integer hotSale3;
    private Integer hotSale4;
    private Integer hotSale5;
    private Integer hotSale6;
    private Integer hotSale7;
    private Integer hotSale8;
    private Integer endSale1;
    private Integer endSale2;
    private String carouselImg1;
    private String carouselImg2;
    private String carouselImg3;
    private Light lightByHotSale1;
    private Light lightByHotSale2;
    private Light lightByHotSale3;
    private Light lightByHotSale4;
    private Light lightByHotSale5;
    private Light lightByHotSale6;
    private Light lightByHotSale7;
    private Light lightByHotSale8;
    private Light lightByEndSale1;
    private Light lightByEndSale2;

    @Id
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "HotSale1", nullable = true)
    public Integer getHotSale1() {
        return hotSale1;
    }

    public void setHotSale1(Integer hotSale1) {
        this.hotSale1 = hotSale1;
    }

    @Basic
    @Column(name = "HotSale2", nullable = true)
    public Integer getHotSale2() {
        return hotSale2;
    }

    public void setHotSale2(Integer hotSale2) {
        this.hotSale2 = hotSale2;
    }

    @Basic
    @Column(name = "HotSale3", nullable = true)
    public Integer getHotSale3() {
        return hotSale3;
    }

    public void setHotSale3(Integer hotSale3) {
        this.hotSale3 = hotSale3;
    }

    @Basic
    @Column(name = "HotSale4", nullable = true)
    public Integer getHotSale4() {
        return hotSale4;
    }

    public void setHotSale4(Integer hotSale4) {
        this.hotSale4 = hotSale4;
    }

    @Basic
    @Column(name = "HotSale5", nullable = true)
    public Integer getHotSale5() {
        return hotSale5;
    }

    public void setHotSale5(Integer hotSale5) {
        this.hotSale5 = hotSale5;
    }

    @Basic
    @Column(name = "HotSale6", nullable = true)
    public Integer getHotSale6() {
        return hotSale6;
    }

    public void setHotSale6(Integer hotSale6) {
        this.hotSale6 = hotSale6;
    }

    @Basic
    @Column(name = "HotSale7", nullable = true)
    public Integer getHotSale7() {
        return hotSale7;
    }

    public void setHotSale7(Integer hotSale7) {
        this.hotSale7 = hotSale7;
    }

    @Basic
    @Column(name = "HotSale8", nullable = true)
    public Integer getHotSale8() {
        return hotSale8;
    }

    public void setHotSale8(Integer hotSale8) {
        this.hotSale8 = hotSale8;
    }

    @Basic
    @Column(name = "EndSale1", nullable = true)
    public Integer getEndSale1() {
        return endSale1;
    }

    public void setEndSale1(Integer endSale1) {
        this.endSale1 = endSale1;
    }

    @Basic
    @Column(name = "EndSale2", nullable = true)
    public Integer getEndSale2() {
        return endSale2;
    }

    public void setEndSale2(Integer endSale2) {
        this.endSale2 = endSale2;
    }

    @Basic
    @Column(name = "CarouselImg1", nullable = true, length = 50)
    public String getCarouselImg1() {
        return carouselImg1;
    }

    public void setCarouselImg1(String carouselImg1) {
        this.carouselImg1 = carouselImg1;
    }

    @Basic
    @Column(name = "CarouselImg2", nullable = true, length = 50)
    public String getCarouselImg2() {
        return carouselImg2;
    }

    public void setCarouselImg2(String carouselImg2) {
        this.carouselImg2 = carouselImg2;
    }

    @Basic
    @Column(name = "CarouselImg3", nullable = true, length = 50)
    public String getCarouselImg3() {
        return carouselImg3;
    }

    public void setCarouselImg3(String carouselImg3) {
        this.carouselImg3 = carouselImg3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Page page = (Page) o;

        if (id != null ? !id.equals(page.id) : page.id != null) return false;
        if (hotSale1 != null ? !hotSale1.equals(page.hotSale1) : page.hotSale1 != null) return false;
        if (hotSale2 != null ? !hotSale2.equals(page.hotSale2) : page.hotSale2 != null) return false;
        if (hotSale3 != null ? !hotSale3.equals(page.hotSale3) : page.hotSale3 != null) return false;
        if (hotSale4 != null ? !hotSale4.equals(page.hotSale4) : page.hotSale4 != null) return false;
        if (hotSale5 != null ? !hotSale5.equals(page.hotSale5) : page.hotSale5 != null) return false;
        if (hotSale6 != null ? !hotSale6.equals(page.hotSale6) : page.hotSale6 != null) return false;
        if (hotSale7 != null ? !hotSale7.equals(page.hotSale7) : page.hotSale7 != null) return false;
        if (hotSale8 != null ? !hotSale8.equals(page.hotSale8) : page.hotSale8 != null) return false;
        if (endSale1 != null ? !endSale1.equals(page.endSale1) : page.endSale1 != null) return false;
        if (endSale2 != null ? !endSale2.equals(page.endSale2) : page.endSale2 != null) return false;
        if (carouselImg1 != null ? !carouselImg1.equals(page.carouselImg1) : page.carouselImg1 != null) return false;
        if (carouselImg2 != null ? !carouselImg2.equals(page.carouselImg2) : page.carouselImg2 != null) return false;
        if (carouselImg3 != null ? !carouselImg3.equals(page.carouselImg3) : page.carouselImg3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotSale1 != null ? hotSale1.hashCode() : 0);
        result = 31 * result + (hotSale2 != null ? hotSale2.hashCode() : 0);
        result = 31 * result + (hotSale3 != null ? hotSale3.hashCode() : 0);
        result = 31 * result + (hotSale4 != null ? hotSale4.hashCode() : 0);
        result = 31 * result + (hotSale5 != null ? hotSale5.hashCode() : 0);
        result = 31 * result + (hotSale6 != null ? hotSale6.hashCode() : 0);
        result = 31 * result + (hotSale7 != null ? hotSale7.hashCode() : 0);
        result = 31 * result + (hotSale8 != null ? hotSale8.hashCode() : 0);
        result = 31 * result + (endSale1 != null ? endSale1.hashCode() : 0);
        result = 31 * result + (endSale2 != null ? endSale2.hashCode() : 0);
        result = 31 * result + (carouselImg1 != null ? carouselImg1.hashCode() : 0);
        result = 31 * result + (carouselImg2 != null ? carouselImg2.hashCode() : 0);
        result = 31 * result + (carouselImg3 != null ? carouselImg3.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale1", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale1() {
        return lightByHotSale1;
    }

    public void setLightByHotSale1(Light lightByHotSale1) {
        this.lightByHotSale1 = lightByHotSale1;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale2", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale2() {
        return lightByHotSale2;
    }

    public void setLightByHotSale2(Light lightByHotSale2) {
        this.lightByHotSale2 = lightByHotSale2;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale3", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale3() {
        return lightByHotSale3;
    }

    public void setLightByHotSale3(Light lightByHotSale3) {
        this.lightByHotSale3 = lightByHotSale3;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale4", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale4() {
        return lightByHotSale4;
    }

    public void setLightByHotSale4(Light lightByHotSale4) {
        this.lightByHotSale4 = lightByHotSale4;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale5", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale5() {
        return lightByHotSale5;
    }

    public void setLightByHotSale5(Light lightByHotSale5) {
        this.lightByHotSale5 = lightByHotSale5;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale6", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale6() {
        return lightByHotSale6;
    }

    public void setLightByHotSale6(Light lightByHotSale6) {
        this.lightByHotSale6 = lightByHotSale6;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale7", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale7() {
        return lightByHotSale7;
    }

    public void setLightByHotSale7(Light lightByHotSale7) {
        this.lightByHotSale7 = lightByHotSale7;
    }

    @ManyToOne
    @JoinColumn(name = "HotSale8", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByHotSale8() {
        return lightByHotSale8;
    }

    public void setLightByHotSale8(Light lightByHotSale8) {
        this.lightByHotSale8 = lightByHotSale8;
    }

    @ManyToOne
    @JoinColumn(name = "EndSale1", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByEndSale1() {
        return lightByEndSale1;
    }

    public void setLightByEndSale1(Light lightByEndSale1) {
        this.lightByEndSale1 = lightByEndSale1;
    }

    @ManyToOne
    @JoinColumn(name = "EndSale2", referencedColumnName = "LightId",insertable = false,updatable = false)
    public Light getLightByEndSale2() {
        return lightByEndSale2;
    }

    public void setLightByEndSale2(Light lightByEndSale2) {
        this.lightByEndSale2 = lightByEndSale2;
    }
}
