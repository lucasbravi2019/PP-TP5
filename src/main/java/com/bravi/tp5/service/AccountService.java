package com.bravi.tp5.service;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Order;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findAccount(String email);
    String getOrderNumber(Customer customer);
    void addOrderToCustomer(Customer customer, Order order);
    void showAccountInfo();
}
