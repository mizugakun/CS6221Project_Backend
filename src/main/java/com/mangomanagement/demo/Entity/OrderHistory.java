package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "OrderHistory")
public class OrderHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId", nullable = false)
    private int orderId;

    @Column(name = "UserId", nullable = false)
    private int userId;

    @Column(name = "OrderDate")
    private LocalDateTime orderDate;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "orderId=" + orderId + '\'' +
                "userId=" + userId + '\'' +
                "orderDate=" + orderDate + '\'' +
                '}';
    }
}
