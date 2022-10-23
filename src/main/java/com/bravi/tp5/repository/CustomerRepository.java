package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Customer;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerRepository {
    
    private static Set<Customer> customers = new HashSet<>();
    private static CustomerRepository instance;
    
    private CustomerRepository() {
        System.out.println("Constructor CustomerRepository");
    }
    
    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }
    
    public void addCustomer(Customer customer) {
        if (customer != null) 
            customers.add(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
    
    public Optional<Customer> findCustomerByEmail(String email) {
        return customers.stream()
                .filter(customer -> email.equals(customer.getEmail()))
                .findFirst();
    }
    
    public Optional<Account> findAccountByCustomerEmail(String email) {
        Optional<Customer> optCustomer = customers.stream()
                .filter(customer -> email.equals(customer.getEmail()))
                .findFirst();
        
        if (optCustomer.isPresent() && optCustomer.get().getAccount() != null) {
            return Optional.of(optCustomer.get().getAccount());
        }
        return Optional.empty();
    }
    
    public void addOrderToAccount(Customer customerToEdit) {
        customers = customers.stream()
                .map(customer -> {
                    if (customer.getId().equals(customerToEdit.getId())) {
                        customer.getAccount().setOrderList(
                                customerToEdit.getAccount().getOrderList());
                    } 
                    return customer;
                }).collect(Collectors.toSet());
    }
    
    public void editCustomer(Customer customerToEdit) {
        customers = customers.stream()
                .map(customer -> {
                    if (customer.getId().equals(customerToEdit.getId())) {
                        return customerToEdit;
                    }
                    return customer;
                }).collect(Collectors.toSet());
    }

}
