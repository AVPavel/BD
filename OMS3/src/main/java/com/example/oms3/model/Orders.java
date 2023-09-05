//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.model;

import java.sql.Time;

public class Orders {
    private int orderId;
    private int userId;
    private String orderStatus;
    private double totalPrice;
    private Time createdAt;
    private Time updatedAt;
    public Orders(){}

    public Orders(int orderId, int userId, String orderStatus, double totalPrice, Time createdAt, Time updatedAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Time getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }

    public Time getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Time updatedAt) {
        this.updatedAt = updatedAt;
    }
}
