package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductRepository {
    
    private static Set<Product> products = new HashSet<>();
    private static int sku = 0;
    
    public void addProduct(Product product) {
        if (product != null) 
            products.add(product);
    }

    public Set<Product> getProducts() {
        return products;
    }

    public int getNextSku() {
        return sku++;
    }
    
}
