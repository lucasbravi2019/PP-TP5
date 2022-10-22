package com.bravi.tp5.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;

public class Product {
    
    private String id = UUID.randomUUID().toString();
    private String name;
    private Supplier<String> supplier;
    private Set<LineItem> lineItemList = new HashSet<>();

    public Product(String name, Supplier<String> supplier) {
        this.name = name;
        this.supplier = supplier;
    }
    
    public void addLineItem(LineItem lineItem) {
        if (lineItem != null) {
            this.lineItemList.add(lineItem);
            lineItem.setProduct(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<LineItem> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(Set<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }
    
}
