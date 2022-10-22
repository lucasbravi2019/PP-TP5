package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Order;
import com.bravi.tp5.repository.OrderRepository;
import com.bravi.tp5.service.OrderService;
import com.bravi.tp5.service.ProductService;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;
    private OrderRepository orderRepository = OrderRepository.getInstance();
    private ProductService productService = ProductServiceImpl.getInstance();
    
    private OrderServiceImpl() {
        
    }
    
    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }
    
    
    @Override
    public Order createOrder() {
        return new Order(null, null, null, null, null, null);
    }

    
    
}
