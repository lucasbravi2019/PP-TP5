package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Order;
import com.bravi.tp5.enumeration.OrderStatus;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderRepository {

    private static Set<Order> orderList = new HashSet<>();
    private static OrderRepository instance;
    
    private OrderRepository() {
        System.out.println("Constructor OrderRepository");
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
    
    public void payOrder(Order orderToPay) {
        changeStatusToOrder(orderToPay, OrderStatus.HOLD);
        
        System.out.println("La orden fue pagada. En breve se hara su envio. Orden: " + orderToPay.getNumber());
        sendOrder(orderToPay);
    }
    
    private void sendOrder(Order orderToSend) {
        changeStatusToOrder(orderToSend, OrderStatus.SHIPPED);

        System.out.println("La orden fue enviada. En breve llegara a su destino.");
        deliveredOrder(orderToSend);
    }
    
    private void deliveredOrder(Order orderDelivered) {
        changeStatusToOrder(orderDelivered, OrderStatus.DELIVERED);

        System.out.println("La orden ya se recibio satisfactoriamente. "
                + "Gracias por elegirnos");
    }
    
    private void changeStatusToOrder(Order orderToEdit, OrderStatus orderStatus) {
        orderList = orderList.stream()
                .map(order -> {
                    if (order.getAccount().getId().equals(orderToEdit.getAccount().getId())
                            && order.getNumber().equals(orderToEdit.getNumber())) {
                        order.setStatus(orderStatus);
                    }
                    return order;
                }).collect(Collectors.toSet());
    }
    
}
