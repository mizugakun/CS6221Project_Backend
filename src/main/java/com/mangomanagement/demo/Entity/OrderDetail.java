package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "OrderDetail")
@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "OrderId", nullable = false)
    private int orderId;

    @Id
    @Column(name = "ItemId", nullable = false)
    private int itemId;

    @Column(name = "Amount", nullable = false)
    private Integer amount;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId + '\'' +
                "itemId=" + itemId + '\'' +
                "amount=" + amount + '\'' +
                '}';
    }
}
