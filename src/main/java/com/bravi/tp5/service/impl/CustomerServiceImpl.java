package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Address;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Phone;
import com.bravi.tp5.repository.CustomerRepository;
import com.bravi.tp5.service.CustomerService;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = CustomerRepository.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private static CustomerServiceImpl instance;
    
    private CustomerServiceImpl() {
        System.out.println("Constructor CustomerServiceImpl");
    }
    
    public static CustomerServiceImpl getInstance() {
        if (instance == null) {
            instance = new CustomerServiceImpl();
        }
        return instance;
    }
    
    @Override
    public void createCustomer() {
        System.out.println("Escriba el email");
        String email = scanner.nextLine();
        System.out.println("Escriba la calle en la que vive");
        String street = scanner.nextLine();
        System.out.println("Escriba el numero de casa");
        Long houseNumber = Long.valueOf(scanner.nextLine());
        System.out.println("Escriba el numero de piso");
        Integer floor = Integer.valueOf(scanner.nextLine());
        System.out.println("Escriba la provincia");
        String state = scanner.nextLine();
        System.out.println("Escriba el pais");
        String country = scanner.nextLine();
        System.out.println("Escriba el prefijo de pais para el telefono");
        Integer countryPrefix = Integer.valueOf(scanner.nextLine());
        System.out.println("Escriba el prefijo de provincia");
        Integer statePrefix = Integer.valueOf(scanner.nextLine());
        System.out.println("Escriba el numero de telefono");
        Long phoneNumber = Long.valueOf(scanner.nextLine());
        
        Phone phone = new Phone(countryPrefix, statePrefix, phoneNumber);
        Address address = new Address(street, state, country, houseNumber, floor);
        Customer customer = new Customer(address, phone, email);
        Account account = new Account(address, customer);
        customer.setAccount(account);
        customerRepository.addCustomer(customer);
    }

    @Override
    public void showCustomersInfo() {
        customerRepository.getCustomers().forEach(customer -> {
            System.out.println("********************");
            System.out.println("Customer: " + customer.getId());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone().getPhoneNumber());
            System.out.println("Address: " + customer.getAddress().getAddress());
            System.out.println("********************");
        });
    }
    
}
