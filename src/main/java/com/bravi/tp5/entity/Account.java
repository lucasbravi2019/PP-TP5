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

    public Account(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public void addPayment(Payment payment) {
        if (payment != null) {
            this.paymentList.add(payment);
            payment.setAccount(this);
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

    
    
    
}
