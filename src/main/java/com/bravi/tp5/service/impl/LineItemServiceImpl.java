package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.LineItem;
import com.bravi.tp5.repository.LineItemRepository;
import com.bravi.tp5.service.LineItemService;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class LineItemServiceImpl implements LineItemService {

    private static LineItemServiceImpl instance;
    private LineItemRepository lineItemRepository = LineItemRepository.getInstance();
    
    private LineItemServiceImpl() {
        System.out.println("Constructor LineItemServiceImpl");
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

    @Override
    public BigDecimal getCartTotal() {
        return lineItemRepository.getCart().stream()
                .map(item -> 
                        item.getPrice().getPriceInPesos())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }
    
    
    @Override
    public void printCart() {
        lineItemRepository.getCart().forEach(item -> {
            System.out.println("********************");
            System.out.println("Producto: " + item.getProduct().getName());
            System.out.println("Cantidad: " + item.getQuantity());
            System.out.println("Precio: $" + item.getPrice().getPriceInPesos());
            System.out.println("********************");
        });
    }
    

}
