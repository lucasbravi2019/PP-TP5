package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.LineItem;
import com.bravi.tp5.repository.LineItemRepository;
import com.bravi.tp5.service.LineItemService;
import java.util.Set;

public class LineItemServiceImpl implements LineItemService {

    private static LineItemServiceImpl instance;
    private LineItemRepository lineItemRepository = LineItemRepository.getInstance();
    
    private LineItemServiceImpl() {
        
    }
    
    public static LineItemServiceImpl getInstance() {
        if (instance == null) {
            instance = new LineItemServiceImpl();
        }
        return instance;
    }
    
    @Override
    public void addItemToCart(LineItem lineItem) {
        lineItemRepository.addItemToCart(lineItem);
    }

    @Override
    public Set<LineItem> getItems() {
        return lineItemRepository.getCart();
    }

    @Override
    public void clearCart() {
        lineItemRepository.clearCart();
    }
    
    
    
    

}
