package com.bravi.tp5.repository;

import com.bravi.tp5.entity.Customer;
import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {
    
    private static Set<Customer> customers = new HashSet<>();
    
    public void addCustomer(Customer customer) {
        if (customer != null) 
            customers.add(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

}
