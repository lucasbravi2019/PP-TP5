package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Order;
import com.bravi.tp5.entity.Payment;
import com.bravi.tp5.enumeration.OrderStatus;
import com.bravi.tp5.repository.CustomerRepository;
import com.bravi.tp5.repository.LineItemRepository;
import com.bravi.tp5.repository.OrderRepository;
import com.bravi.tp5.service.PaymentService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentServiceImpl implements PaymentService {

    private static PaymentServiceImpl instance;
    private Scanner scanner = new Scanner(System.in);
    private CustomerRepository customerRepository = CustomerRepository.getInstance();
    private LineItemRepository lineItemRepository = LineItemRepository.getInstance();
    private OrderRepository orderRepository = OrderRepository.getInstance();

    private PaymentServiceImpl() {
        System.out.println("Constructor PaymentServiceImpl");
    }
    
    public static PaymentServiceImpl getInstance() {
        if (instance == null) {
            instance = new PaymentServiceImpl();
        }
        return instance;
    }
    
    @Override
    public void payOrder() {
        System.out.println("Indique su email");
        String email = scanner.nextLine();
        Optional<Customer> customer = customerRepository
                .findCustomerByEmail(email);
        
        if (customer.isPresent() && customer.get().getAccount() != null 
                    && isNotEmpty(customer.get().getAccount().getOrderList())) {
            Account account = customer.get().getAccount();
            Set<Order> orderList = account.getOrderList().stream()
                    .filter(order -> OrderStatus.NEW.equals(order.getStatus()))
                    .collect(Collectors.toSet());
            
            choseOrderToPay(orderList, account);
        }
        
    }

    private void choseOrderToPay(Set<Order> orderList, Account account) {
        if (!orderList.isEmpty()) {
            System.out.println("Qué orden desea pagar?");
            orderList.forEach(order -> System.out.println(order.getNumber()
                    + ": $ " + order.getTotal().setScale(2, RoundingMode.CEILING)));
            String number = scanner.nextLine();
            Order orderPaid = orderList.stream()
                    .filter(order -> number.equals(order.getNumber()))
                    .findFirst()
                    .orElse(null);
            if (orderPaid == null) {
                System.out.println("La orden no fue encontrada");
            } else {
                makePayment(orderPaid, account);
            }
            lineItemRepository.clearCart();
        }
    }

    private void makePayment(Order orderPaid, Account account) {
        BigDecimal total = orderPaid.getTotal().setScale(2, RoundingMode.CEILING);
        Payment payment = new Payment(total, "Pago orden: "
                + orderPaid.getNumber(), account, orderPaid);
        account.addPayment(payment);
        try {
            orderRepository.payOrder(orderPaid);
        } catch (InterruptedException ex) {
            System.out.println("Se interrumpió el proceso de pago");
        }
        customerRepository.editCustomer(account.getCustomer());
    }

    @Override
    public void showPayments() {
        System.out.println("Ingrese su email");
        String email = scanner.nextLine();
        Optional<Customer> customer = customerRepository
                .findCustomerByEmail(email);
        
        if (customer.isEmpty()) {
            System.out.println("No se encontró cliente con email: " + email);
        }
        if (customer.isPresent() && customer.get().getAccount() != null 
                    && !isNotEmpty(customer.get().getAccount().getPaymentList())) {
            System.out.println("No hay pagos registrados para el cliente: " + email);
        }
        if (customer.isPresent() && customer.get().getAccount() != null 
                    && isNotEmpty(customer.get().getAccount().getPaymentList())) {
            customer.get().getAccount().getPaymentList().forEach(Payment::printPayment);
        }
    }
    
    


    private boolean isNotEmpty(Collection collection) {
        if (collection == null) 
            return false;
        if (collection.isEmpty()) {
            return false;
        }
        return true;
    }
    
    
}
