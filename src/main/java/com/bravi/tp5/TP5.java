package com.bravi.tp5;

import com.bravi.tp5.entity.Account;
import com.bravi.tp5.entity.Address;
import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.Phone;
import com.bravi.tp5.entity.Product;
import com.bravi.tp5.exception.CustomerNotFoundException;
import com.bravi.tp5.service.CustomerService;
import com.bravi.tp5.service.ProductService;
import com.bravi.tp5.service.impl.CustomerServiceImpl;
import com.bravi.tp5.service.impl.ProductServiceImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TP5 {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Customer> customers = new HashSet<>();
    private static Set<Product> products = new HashSet<>();
    private static CustomerService customerService = new CustomerServiceImpl(); 
    private static ProductService productService = new ProductServiceImpl();
    
    public static void main(String[] args) {
        int option = 0;
        while (option != 9) {
            System.out.println("1. Crear nuevo cliente");
            System.out.println("2. Crear nuevo producto");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("1. Crear nuevo cliente");
            System.out.println("Indique numero de opcion deseada");
            option = scanner.nextInt();
            switch (option) {
                case 1: createClient();
                    break;
                case 2: createProduct();
                    break;
                default: System.out.println("Se eligio una opcion invalida");
                    break;
            }
        }
        
    }

    private static void createClient() {
        customerService.createCustomer();
    }

    private static void buyProduct() {
        
        
    }

    private static void createProduct() {
        productService.createProduct();
    }

}
