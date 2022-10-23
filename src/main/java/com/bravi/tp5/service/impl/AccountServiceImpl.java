package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Order;
import com.bravi.tp5.repository.CustomerRepository;
import com.bravi.tp5.service.AccountService;
import java.util.Optional;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl instance;
    private Scanner scanner = new Scanner(System.in);
    private CustomerRepository customerRepository = CustomerRepository.getInstance();

    private AccountServiceImpl() {
        System.out.println("Constructor AccountServiceImpl");
    }

    public static AccountServiceImpl getInstance() {
        if (instance == null) {
            instance = new AccountServiceImpl();
        }
        return instance;
    }

    @Override
    public Optional<Account> findAccount(String email) {
        return customerRepository.findAccountByCustomerEmail(email);
    }

    @Override
    public String getOrderNumber(Customer customer) {
        if (customer.getAccount() != null) {
            return String.valueOf(customer.getAccount().getOrderList().size() + 1);
        }
        return "0";
    }

    @Override
    public void addOrderToCustomer(Customer customer, Order order) {
        customer.getAccount().addOrder(order);
        customerRepository.addOrderToAccount(customer);
    }

    @Override
    public void showAccountInfo() {
        System.out.println("Por favor ingrese el email del cual quiere conocer"
                + " los detalles de cuenta");
        String email = scanner.nextLine();
        Optional<Account> optAccount = findAccount(email);
        optAccount.ifPresent(Account::printAccount);
    }

}
