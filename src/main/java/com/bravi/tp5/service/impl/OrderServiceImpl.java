package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Order;
import com.bravi.tp5.enumeration.OrderStatus;
import com.bravi.tp5.exception.AccountNotFoundException;
import com.bravi.tp5.repository.OrderRepository;
import com.bravi.tp5.service.AccountService;
import com.bravi.tp5.service.LineItemService;
import com.bravi.tp5.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;
    private OrderRepository orderRepository = OrderRepository.getInstance();
    private AccountService accountService = AccountServiceImpl.getInstance();
    private LineItemService lineItemService = LineItemServiceImpl.getInstance();
    private Scanner scanner = new Scanner(System.in);
    
    private OrderServiceImpl() {
        System.out.println("Constructor OrderServiceImpl");
    }
    
    public static OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }
    
    
    @Override
    public void createOrder() {
        System.out.println("Por favor ingrese su email");
        String email = scanner.nextLine();
        Optional<Account> optAccount = accountService.findAccount(email);
        if (optAccount.isEmpty()) {
            throw new AccountNotFoundException("Account not found for email: " + email);
        }
        String orderNumber = accountService.getOrderNumber(optAccount.get().getCustomer());
        BigDecimal total = lineItemService.getCartTotal();
        Order order = new Order(orderNumber, LocalDate.now(), null, 
                optAccount.get().getBillingAddress(), OrderStatus.NEW, total);
        order.setAccount(optAccount.get());
        orderRepository.addOrder(order);
        accountService.addOrderToCustomer(optAccount.get().getCustomer(), order);
        System.out.println("La orden fue creada con exito");
        System.out.println("Orden Numero: " + order.getNumber());
    }

    @Override
    public void printOrders() {
        orderRepository.getOrders().forEach(order -> {
            order.printOrder();
        });
    }
    
    
        
}
