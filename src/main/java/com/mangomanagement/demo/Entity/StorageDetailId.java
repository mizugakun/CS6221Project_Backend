package com.mangomanagement.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

public class StorageDetailId implements Serializable {
    private Integer userId;
    private Integer itemId;

    @Override
    public int hashCode() {
        return Objects.hash(userId, itemId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        StorageDetailId Id = (StorageDetailId) obj;
        return Objects.equals(this.userId, Id.userId) && Objects.equals(this.itemId, Id.itemId);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
