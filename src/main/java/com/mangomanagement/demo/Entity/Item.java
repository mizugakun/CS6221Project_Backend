package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemId", nullable = false)
    private int itemId;

    @Column(name = "ItemName", nullable = false)
    private String itemName;

    @Column(name = "ProducerId")
    private int producerId;

    @Column(name = "SellerId")
    private int sellerId;

    @Column(name = "Amount", nullable = false)
    private String amount;

    @Column(name = "Unit")
    private String unit;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId + '\'' +
                "itemName=" + itemName + '\'' +
                "producerId=" + producerId + '\'' +
                "sellerId=" + sellerId + '\'' +
                "amount=" + amount + '\'' +
                "unit=" + unit + '\'' +
                "price=" + price + '\'' +
                '}';
    }
}
