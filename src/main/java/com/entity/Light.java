package com.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by AgZou on 2017/5/1.
 */
@Entity
public class Light {
    private Integer lightId;
    private Integer catagoryId;
    private Integer brandId;
    private Integer styleId;
    private String stuff;
    private String color;
    private String locate;
    private Integer price;
    private Integer quantity;
    private String description;
    private String images;
    private Collection<Comments> commentsByLightId;
    private Catagory catagoryByCatagoryId;
    private Brand brandByBrandId;
    private Stryle stryleByStyleId;
    private Collection<Myshopcart> myshopcartsByLightId;
    private Collection<Orders> ordersByLightId;
    private Collection<Wishlist> wishlistsByLightId;

    @Id
    @Column(name = "LightId", nullable = false)
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
    @Column(name = "Stuff", nullable = true, length = 20)
    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    @Basic
    @Column(name = "Color", nullable = true, length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "Locate", nullable = true, length = 20)
    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
    @Column(name = "Images", nullable = true, length = 50)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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
        if (stuff != null ? !stuff.equals(light.stuff) : light.stuff != null) return false;
        if (color != null ? !color.equals(light.color) : light.color != null) return false;
        if (locate != null ? !locate.equals(light.locate) : light.locate != null) return false;
        if (price != null ? !price.equals(light.price) : light.price != null) return false;
        if (quantity != null ? !quantity.equals(light.quantity) : light.quantity != null) return false;
        if (description != null ? !description.equals(light.description) : light.description != null) return false;
        if (images != null ? !images.equals(light.images) : light.images != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lightId != null ? lightId.hashCode() : 0;
        result = 31 * result + (catagoryId != null ? catagoryId.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (styleId != null ? styleId.hashCode() : 0);
        result = 31 * result + (stuff != null ? stuff.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (locate != null ? locate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Comments> getCommentsByLightId() {
        return commentsByLightId;
    }

    public void setCommentsByLightId(Collection<Comments> commentsByLightId) {
        this.commentsByLightId = commentsByLightId;
    }

    @ManyToOne
    @JoinColumn(name = "CatagoryId", referencedColumnName = "CatagoryId", nullable = false)
    public Catagory getCatagoryByCatagoryId() {
        return catagoryByCatagoryId;
    }

    public void setCatagoryByCatagoryId(Catagory catagoryByCatagoryId) {
        this.catagoryByCatagoryId = catagoryByCatagoryId;
    }

    @ManyToOne
    @JoinColumn(name = "BrandId", referencedColumnName = "BrandId", nullable = false)
    public Brand getBrandByBrandId() {
        return brandByBrandId;
    }

    public void setBrandByBrandId(Brand brandByBrandId) {
        this.brandByBrandId = brandByBrandId;
    }

    @ManyToOne
    @JoinColumn(name = "StyleId", referencedColumnName = "StyleId", nullable = false)
    public Stryle getStryleByStyleId() {
        return stryleByStyleId;
    }

    public void setStryleByStyleId(Stryle stryleByStyleId) {
        this.stryleByStyleId = stryleByStyleId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Myshopcart> getMyshopcartsByLightId() {
        return myshopcartsByLightId;
    }

    public void setMyshopcartsByLightId(Collection<Myshopcart> myshopcartsByLightId) {
        this.myshopcartsByLightId = myshopcartsByLightId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Orders> getOrdersByLightId() {
        return ordersByLightId;
    }

    public void setOrdersByLightId(Collection<Orders> ordersByLightId) {
        this.ordersByLightId = ordersByLightId;
    }

    @OneToMany(mappedBy = "lightByLightId")
    public Collection<Wishlist> getWishlistsByLightId() {
        return wishlistsByLightId;
    }

    public void setWishlistsByLightId(Collection<Wishlist> wishlistsByLightId) {
        this.wishlistsByLightId = wishlistsByLightId;
    }
}
