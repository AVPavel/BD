//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.oms3.model;

import java.sql.Time;

public class Product {
    private Integer productId;
    private String productName;
    private Integer categoryId;
    private Integer brandID;
    private Integer supplierID;
    private double price;
    private String description;
    private String imageURL;
    private Integer stock;
    private Time createdAt;
    private Time updatedAt;

    public Product(Integer productId, String productName, Integer categoryId, Integer brandID, Integer supplierID, double price, String description, String imageURL, Integer stock, Time createdAt, Time updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandID = brandID;
        this.supplierID = supplierID;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, Integer categoryId, Integer brandID, Integer supplierID, Double price, String description, Integer stock) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandID = brandID;
        this.supplierID = supplierID;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Product(String productName, Integer categoryId, Integer brandID, Integer supplierID, Double price, String description, Integer stock) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.brandID = brandID;
        this.supplierID = supplierID;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandID() {
        return this.brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public Integer getSupplierID() {
        return this.supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
