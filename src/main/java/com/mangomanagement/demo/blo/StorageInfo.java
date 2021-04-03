package com.mangomanagement.demo.blo;

import java.math.BigDecimal;

public class StorageInfo {
    Integer itemId;
    String itemName;
    Integer remaining;
    BigDecimal purchaseFrequency;
    BigDecimal purchaseFrequency_user;

    public StorageInfo(int itemId, String itemName, Integer remaining,
                       BigDecimal purchaseFrequency, BigDecimal purchaseFrequency_user) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.remaining = remaining;
        this.purchaseFrequency = purchaseFrequency;
        this.purchaseFrequency_user = purchaseFrequency_user;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getPurchaseFrequency() {
        return purchaseFrequency;
    }

    public void setPurchaseFrequency(BigDecimal purchaseFrequency) {
        this.purchaseFrequency = purchaseFrequency;
    }

    public BigDecimal getPurchaseFrequency_user() {
        return purchaseFrequency_user;
    }

    public void setPurchaseFrequency_user(BigDecimal purchaseFrequency_user) {
        this.purchaseFrequency_user = purchaseFrequency_user;
    }
}
