package com.bravi.tp5.entity;

import java.util.UUID;

public class Customer {

    private String id = UUID.randomUUID().toString();
    private Address address;
    private Phone phone;
    private String email;
    private Account account;

    public Customer(Address address, Phone phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        System.out.println("Constructor Customer");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}
