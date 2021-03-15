package com.mangomanagement.demo.Entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable {
    private Integer orderId;
    private Integer itemId;

    public OrderDetailId(Integer orderId, Integer itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OrderDetailId Id = (OrderDetailId) obj;
        return Objects.equals(this.orderId, Id.orderId) && Objects.equals(this.itemId, Id.itemId);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
