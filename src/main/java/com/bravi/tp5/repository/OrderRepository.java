package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Order;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {

    private static Set<Order> orderList = new HashSet<>();
    private static OrderRepository instance;
    
    private OrderRepository() {
        
    }
    
    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }
    
    public void addOrder(Order order) {
        if (order != null) {
            orderList.add(order);
        }
    }

    public Set<Order> getOrders() {
        return orderList;
    }
    
}
