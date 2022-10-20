package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Address;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Phone;
import com.bravi.tp5.repository.CustomerRepository;
import com.bravi.tp5.service.CustomerService;
import java.util.Scanner;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();
    private Scanner scanner = new Scanner(System.in);
    
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
        Account account = new Account(address);
        Customer customer = new Customer(address, phone, email, account);
        
        customerRepository.addCustomer(customer);
    }
    
}
