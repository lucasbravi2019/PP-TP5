package com.bravi.tp5.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Account {
    
    private String id = UUID.randomUUID().toString();
    private Address billingAddress;
    private Boolean isClosed = Boolean.FALSE;
    private LocalDate open = LocalDate.now();
    private LocalDate closed;
    private Set<Payment> paymentList = new HashSet<>();
    private Set<Order> orderList = new HashSet<>();
    private Customer customer;

    public Account(Address billingAddress, Customer customer) {
        this.billingAddress = billingAddress;
        this.customer = customer;
        System.out.println("Constructor Account");
    }
    
    public void addPayment(Payment payment) {
        if (payment != null) {
            this.paymentList.add(payment);
            payment.setAccount(this);
        }
    }
    
    public void addOrder(Order order) {
        if (order != null) {
            this.orderList.add(order);
            order.setAccount(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDate getOpen() {
        return open;
    }

    public void setOpen(LocalDate open) {
        this.open = open;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }

    public Set<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Set<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void printAccount() {
        System.out.println("********************");
        System.out.println("ID: " + id);
        System.out.println("Billing address: " + billingAddress.getAddress());
        System.out.println("Cuenta cerrada: " + (isClosed ? "SI" : "NO"));
        System.out.println("Fecha de alta de cuenta: " + getDate(open));
        if (closed != null) {
            System.out.println("Fecha de baja de cuenta: " + getDate(closed));
        }
        System.out.println("********************");
    }
    
    private String getDate(LocalDate date) {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }
    
    
}
