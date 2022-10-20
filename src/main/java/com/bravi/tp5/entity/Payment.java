package com.bravi.tp5.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private String id;
    private LocalDate paid;
    private BigDecimal total;
    private String details;
    private Account account;
    private Order order;

    public Payment(String id, LocalDate paid, BigDecimal total, String details) {
        this.id = id;
        this.paid = paid;
        this.total = total;
        this.details = details;
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
    
}
