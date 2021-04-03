package com.mangomanagement.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="User")
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private int userId;

    @Column(name = "UserAccount", nullable = false)
    private String userAccount;

    @Column(name = "UserPassword", nullable = false)
    private String userPassword;

    @Column(name = "PurchaseWeekDay")
    private Integer purchaseWeekDay;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Integer getPurchaseWeekDay() {
        return purchaseWeekDay;
    }

    public void setPurchaseWeekDay(Integer purchaseWeekDay) {
        this.purchaseWeekDay = purchaseWeekDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId + '\'' +
                "userAccount=" + userAccount + '\'' +
                "userPassword=" + userPassword + '\'' +
                '}';
    }
}
