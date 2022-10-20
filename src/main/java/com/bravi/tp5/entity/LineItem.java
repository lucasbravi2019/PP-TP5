package com.bravi.tp5.entity;

public class LineItem {
    
    private Integer quantity;
    private Price price;
    private Product product;

    public LineItem(Integer quantity, Price price) {
        this.quantity = quantity;
        this.price = price;
    }

    public LineItem(Integer quantity, Price price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
}
