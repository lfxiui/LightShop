package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/9.
 */
@Entity
@Table(name = "light")
@DynamicUpdate
@JsonIgnoreProperties({"commentsByLightId","myshopcartsByLightId","orderlightsByLightId","wishlistsByLightId"})
public class Light {
    private Integer lightId;
    private Integer catagoryId;
    private Integer brandId;
    private Integer styleId;
    private Double price;
    private Integer quantity;
    private String description;
    private String image1;
    private String image2;
    private String image3;
    private String name;
    private Integer stuffId;
    private Integer locateId;
    private Double discount;
    private Integer click;
    private Integer sale;
    private Integer store;
    private Collection<Comments> commentsByLightId;
    private Catagory catagoryByCatagoryId;
    private Brand brandByBrandId;
    private Style styleByStyleId;
    private Stuff stuffByStuffId;
    private Locate locateByLocateId;
    private Collection<Myshopcart> myshopcartsByLightId;
    private Collection<Orderlight> orderlightsByLightId;
    private Collection<Wishlist> wishlistsByLightId;

    @Id
    @Column(name = "LightId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getLightId() {
        return lightId;
    }

    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    @Basic
    @Column(name = "CatagoryId", nullable = false)
    public Integer getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(Integer catagoryId) {
        this.catagoryId = catagoryId;
    }

    @Basic
    @Column(name = "BrandId", nullable = false)
    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "StyleId", nullable = false)
    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Image1", nullable = true, length = 50)
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "Image2", nullable = true, length = 50)
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "Image3", nullable = true, length = 50)
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "StuffId", nullable = false)
    public Integer getStuffId() {
        return stuffId;
    }

    public void setStuffId(Integer stuffId) {
        this.stuffId = stuffId;
    }

    @Basic
    @Column(name = "LocateId", nullable = false)
    public Integer getLocateId() {
        return locateId;
    }

    public void setLocateId(Integer locateId) {
        this.locateId = locateId;
    }

    @Basic
    @Column(name = "Discount", nullable = false)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "Click")
    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    @Basic
    @Column(name = "Sale")
    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Basic
    @Column(name = "Store")
    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Light light = (Light) o;

        if (lightId != null ? !lightId.equals(light.lightId) : light.lightId != null) return false;
        if (catagoryId != null ? !catagoryId.equals(light.catagoryId) : light.catagoryId != null) return false;
        if (brandId != null ? !brandId.equals(light.brandId) : light.brandId != null) return false;
        if (styleId != null ? !styleId.equals(light.styleId) : light.styleId != null) return false;
        if (price != null ? !price.equals(light.price) : light.price != null) return false;
        if (quantity != null ? !quantity.equals(light.quantity) : light.quantity != null) return false;
        if (description != null ? !description.equals(light.description) : light.description != null) return false;
        if (image1 != null ? !image1.equals(light.image1) : light.image1 != null) return false;
        if (image2 != null ? !image2.equals(light.image2) : light.image2 != null) return false;
        if (image3 != null ? !image3.equals(light.image3) : light.image3 != null) return false;
        if (name != null ? !name.equals(light.name) : light.name != null) return false;
        if (stuffId != null ? !stuffId.equals(light.stuffId) : light.stuffId != null) return false;
        if (locateId != null ? !locateId.equals(light.locateId) : light.locateId != null) return false;
        if (discount != null ? !discount.equals(light.discount) : light.discount != null) return false;
        if (click != null ? !click.equals(light.click) : light.click != null) return false;
        if (sale != null ? !sale.equals(light.sale) : light.sale != null) return false;
        if (store != null ? !store.equals(light.store) : light.store != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lightId != null ? lightId.hashCode() : 0;
        result = 31 * result + (catagoryId != null ? catagoryId.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (styleId != null ? styleId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (image2 != null ? image2.hashCode() : 0);
        result = 31 * result + (image3 != null ? image3.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (stuffId != null ? stuffId.hashCode() : 0);
        result = 31 * result + (locateId != null ? locateId.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (click != null ? click.hashCode() : 0);
        result = 31 * result + (sale != null ? sale.hashCode() : 0);
        result = 31 * result + (store != null ? store.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Comments> getCommentsByLightId() {
        return commentsByLightId;
    }

    public void setCommentsByLightId(Collection<Comments> commentsByLightId) {
        this.commentsByLightId = commentsByLightId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CatagoryId", referencedColumnName = "CatagoryId", nullable = false,insertable = false,updatable = false)
    public Catagory getCatagoryByCatagoryId() {
        return catagoryByCatagoryId;
    }

    public void setCatagoryByCatagoryId(Catagory catagoryByCatagoryId) {
        this.catagoryByCatagoryId = catagoryByCatagoryId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BrandId", referencedColumnName = "BrandId", nullable = false,insertable = false,updatable = false)
    public Brand getBrandByBrandId() {
        return brandByBrandId;
    }

    public void setBrandByBrandId(Brand brandByBrandId) {
        this.brandByBrandId = brandByBrandId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StyleId", referencedColumnName = "StyleId", nullable = false,insertable = false,updatable = false)
    public Style getStyleByStyleId() {
        return styleByStyleId;
    }

    public void setStyleByStyleId(Style styleByStyleId) {
        this.styleByStyleId = styleByStyleId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StuffId", referencedColumnName = "StuffId", nullable = false,insertable = false,updatable = false)
    public Stuff getStuffByStuffId() {
        return stuffByStuffId;
    }

    public void setStuffByStuffId(Stuff stuffByStuffId) {
        this.stuffByStuffId = stuffByStuffId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LocateId", referencedColumnName = "LocateId", nullable = false,insertable = false,updatable = false)
    public Locate getLocateByLocateId() {
        return locateByLocateId;
    }

    public void setLocateByLocateId(Locate locateByLocateId) {
        this.locateByLocateId = locateByLocateId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Myshopcart> getMyshopcartsByLightId() {
        return myshopcartsByLightId;
    }

    public void setMyshopcartsByLightId(Collection<Myshopcart> myshopcartsByLightId) {
        this.myshopcartsByLightId = myshopcartsByLightId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Orderlight> getOrderlightsByLightId() {
        return orderlightsByLightId;
    }

    public void setOrderlightsByLightId(Collection<Orderlight> orderlightsByLightId) {
        this.orderlightsByLightId = orderlightsByLightId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Wishlist> getWishlistsByLightId() {
        return wishlistsByLightId;
    }

    public void setWishlistsByLightId(Collection<Wishlist> wishlistsByLightId) {
        this.wishlistsByLightId = wishlistsByLightId;
    }
}
