package com.mangomanagement.demo.blo;

public class StorageInfo {
    Integer itemId;
    String itemName;
    Integer remaining;
    double purchaseFrequency;
    public StorageInfo(int itemId, String itemName, Integer remaining,
                       double purchaseFrequency) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.remaining = remaining;
        this.purchaseFrequency = purchaseFrequency;
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

    public double getPurchaseFrequency() {
        return purchaseFrequency;
    }

    public void setPurchaseFrequency(double purchaseFrequency) {
        this.purchaseFrequency = purchaseFrequency;
    }
}
