package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "StorageDetail")
@IdClass(StorageDetailId.class)
public class StorageDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UserId", nullable = false)
    private int userId;

    @Id
    @Column(name = "ItemId", nullable = false)
    private int itemId;

    @Column(name = "Remaining", nullable = false)
    private Integer remaining;

    @Column(name = "PurchaseFrequency")
    private double purchaseFrequency;

    @Column(name = "PurchaseFrequency_User")
    private double purchaseFrequency_User;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public double getPurchaseFrequency() {
        return purchaseFrequency;
    }

    public void setPurchaseFrequency(double purchaseFrequency) {
        this.purchaseFrequency = purchaseFrequency;
    }

    public double getPurchaseFrequency_User() {
        return purchaseFrequency_User;
    }

    public void setPurchaseFrequency_User(double purchaseFrequency_User) {
        this.purchaseFrequency_User = purchaseFrequency_User;
    }

    @Override
    public String toString() {
        return "StorageDetail{" +
                "userId=" + userId + '\'' +
                "itemId=" + itemId + '\'' +
                "remaining=" + remaining + '\'' +
                '}';
    }
}
