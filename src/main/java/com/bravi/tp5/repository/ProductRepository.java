package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductRepository {
    
    private static Set<Product> products = new HashSet<>();
    private static Set<Product> cart = new HashSet<>();
    private static int sku = 0;
    private static ProductRepository instance;
    
    private ProductRepository() {
        
    }
    
    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }
    
    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            sku++;
        }
    }

    public Set<Product> getProducts() {
        return products;
    }

    public int getSku() {
        return sku;
    }
    
    
    
    
    
}
