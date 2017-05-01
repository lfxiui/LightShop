package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by AgZou on 2017/5/1.
 */
@Entity
public class Statistics {
    private Integer lightId;
    private Integer clicks;
    private Integer storeCount;
    private Integer stateCount;

    @Id
    @Column(name = "LightId", nullable = false)
    public Integer getLightId() {
        return lightId;
    }

    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    @Basic
    @Column(name = "Clicks", nullable = false)
    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    @Basic
    @Column(name = "StoreCount", nullable = false)
    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    @Basic
    @Column(name = "StateCount", nullable = false)
    public Integer getStateCount() {
        return stateCount;
    }

    public void setStateCount(Integer stateCount) {
        this.stateCount = stateCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistics that = (Statistics) o;

        if (lightId != null ? !lightId.equals(that.lightId) : that.lightId != null) return false;
        if (clicks != null ? !clicks.equals(that.clicks) : that.clicks != null) return false;
        if (storeCount != null ? !storeCount.equals(that.storeCount) : that.storeCount != null) return false;
        if (stateCount != null ? !stateCount.equals(that.stateCount) : that.stateCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lightId != null ? lightId.hashCode() : 0;
        result = 31 * result + (clicks != null ? clicks.hashCode() : 0);
        result = 31 * result + (storeCount != null ? storeCount.hashCode() : 0);
        result = 31 * result + (stateCount != null ? stateCount.hashCode() : 0);
        return result;
    }
}
