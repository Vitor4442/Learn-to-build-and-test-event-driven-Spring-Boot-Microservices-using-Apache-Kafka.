package com.appsdeveloperblog.ws.ProductsMicroservice;

import java.math.BigDecimal;

public class ProductCreatedEvent {
    private String ProductId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

    public ProductCreatedEvent(){

    }

    public ProductCreatedEvent(String productId, String title, BigDecimal price, Integer quantity) {
        ProductId = productId;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
