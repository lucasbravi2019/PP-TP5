package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Order;
import com.bravi.tp5.enumeration.OrderStatus;
import java.time.LocalDate;
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
    
    public void payOrder(Order orderToPay) throws InterruptedException {
        changeStatusToOrder(orderToPay, OrderStatus.HOLD, null);
        
        System.out.println("La orden fue pagada. En breve se hara su envío");
        orderToPay.printOrder();
        Thread.sleep(1000);
        sendOrder(orderToPay);
    }
    
    private void sendOrder(Order orderToSend) throws InterruptedException {
        changeStatusToOrder(orderToSend, OrderStatus.SHIPPED, LocalDate.now());

        System.out.println("La orden fue enviada. En breve llegara a su destino.");
        orderToSend.printOrder();
        Thread.sleep(1000);
        deliveredOrder(orderToSend);
    }
    
    private void deliveredOrder(Order orderDelivered) throws InterruptedException {
        changeStatusToOrder(orderDelivered, OrderStatus.DELIVERED, null);
        orderDelivered.printOrder();
        Thread.sleep(1000);
        System.out.println("La orden ya se recibio satisfactoriamente. "
                + "Gracias por elegirnos");
    }
    
    private void changeStatusToOrder(Order orderToEdit, OrderStatus orderStatus, LocalDate shippedDate) {
        orderList = orderList.stream()
                .map(order -> {
                    if (order.getAccount().getId().equals(orderToEdit.getAccount().getId())
                            && order.getNumber().equals(orderToEdit.getNumber())) {
                        order.setStatus(orderStatus);
                        if (shippedDate != null) {
                            order.setShipped(shippedDate);
                        }
                    }
                    return order;
                }).collect(Collectors.toSet());
    }
    
}
