package com.codegym.model;

public class Product {
    private String productId;
    private String productName;
    private int productAmount;
    private String description;

    public Product(String productId, String productName, int productAmount, String description) {
        this.productId = productId;
        this.productName = productName;
        this.productAmount = productAmount;
        this.description = description;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
