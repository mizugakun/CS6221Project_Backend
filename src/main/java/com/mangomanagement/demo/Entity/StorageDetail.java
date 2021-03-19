package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;


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

    @Override
    public String toString() {
        return "StorageDetail{" +
                "userId=" + userId + '\'' +
                "itemId=" + itemId + '\'' +
                "remaining=" + remaining + '\'' +
                '}';
    }
}
