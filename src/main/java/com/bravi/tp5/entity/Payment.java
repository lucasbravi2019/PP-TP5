package com.bravi.tp5.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

public class Payment {

    private String id = UUID.randomUUID().toString();
    private LocalDate paid = LocalDate.now();
    private BigDecimal total;
    private String details;
    private Account account;
    private Order order;

    public Payment(BigDecimal total, String details, 
                Account account, Order order) {
        this.total = total;
        this.details = details;
        this.account = account;
        this.order = order;
        System.out.println("Constructor Payment");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getPaid() {
        return paid;
    }

    public void setPaid(LocalDate paid) {
        this.paid = paid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void printPayment() {
        System.out.println("********************");
        System.out.println("Pago id: " + id);
        System.out.println("Total: $ " + total.setScale(2, RoundingMode.CEILING));
        System.out.println("Details: " + details);
        System.out.println("Orden Numero: " + order.getNumber());
        System.out.println("********************");
    }
    
}
