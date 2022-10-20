package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.Customer;
import com.bravi.tp5.entity.LineItem;
import com.bravi.tp5.entity.Price;
import com.bravi.tp5.entity.Product;
import com.bravi.tp5.exception.CustomerNotFoundException;
import com.bravi.tp5.repository.ProductRepository;
import com.bravi.tp5.service.ProductService;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private Scanner scanner = new Scanner(System.in);
    private ProductRepository productRepository = new ProductRepository();
    
    @Override
    public void createProduct() {
        System.out.println("Ingrese el nombre del producto");
        String productName = scanner.nextLine();
        System.out.println("Ingrese la cantidad");
        Integer quantity = scanner.nextInt();
        System.out.println("Ingrese el precio");
        BigDecimal price = scanner.nextBigDecimal();
        Price totalPrice = new Price(price, BigDecimal.valueOf(281));
        LineItem lineItem = new LineItem(quantity, totalPrice);
        Product product = new Product(productName, 
                () -> String.format("BR-%d", productRepository.getNextSku()));
        
        product.addLineItem(lineItem);
        productRepository.addProduct(product);
    }
    
    private Customer retrieveCustomer(Set<Customer> customers) {
        System.out.println("Escriba su email");
        String email = scanner.nextLine();
        Optional<Customer> customer = customers.stream()
                .filter(client -> email.equals(client.getEmail()))
                .findFirst();
        
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with email " + email 
                    + " was not found.");
        }
        
        return customer.get();
    }

}
