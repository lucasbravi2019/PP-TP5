package com.bravi.tp5;

import com.bravi.tp5.service.CustomerService;
import com.bravi.tp5.service.ProductService;
import com.bravi.tp5.service.impl.CustomerServiceImpl;
import com.bravi.tp5.service.impl.ProductServiceImpl;
import java.util.Scanner;

public class TP5 {
    
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = CustomerServiceImpl.getInstance(); 
    private static ProductService productService = ProductServiceImpl.getInstance();
    
    public static void main(String[] args) {
        int option = 0;
        while (option != 9) {
            System.out.println("1. Crear nuevo cliente");
            System.out.println("2. Crear nuevo producto");
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Imprimir carrito");
            System.out.println("5. Crear nueva orden");
            System.out.println("Indique numero de opcion deseada");
            option = scanner.nextInt();
            switch (option) {
                case 1: createClient();
                    break;
                case 2: createProduct();
                    break;
                case 3: buyProduct();
                    break;
                case 4: printCart();
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
        productService.buyProducts();
        
    }

    private static void createProduct() {
        productService.createProduct();
    }

    private static void createOrder() {
        
    }
    
    private static void printCart() {
        productService.printCart();
    }

}
