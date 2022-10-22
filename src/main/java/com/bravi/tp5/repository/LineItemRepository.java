package com.bravi.tp5.repository;

import com.bravi.tp5.entity.LineItem;
import java.util.HashSet;
import java.util.Set;

public class LineItemRepository {
    
    private static Set<LineItem> cart = new HashSet<>();
    private static LineItemRepository instance;
    
    private LineItemRepository() {
        
    }
    
    public static LineItemRepository getInstance() {
        if (instance == null) {
            instance = new LineItemRepository();
        }
        return instance;
    }
    
    public void addItemToCart(LineItem lineItem) {
        if (lineItem != null) {
            cart.add(lineItem);
        }
    }
    
    public Set<LineItem> getCart() {
        return cart;
    }
    
    public void clearCart() {
        cart.clear();
    }

}
