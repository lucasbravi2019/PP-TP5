package com.bravi.tp5;

import com.bravi.tp5.service.AccountService;
import com.bravi.tp5.service.CustomerService;
import com.bravi.tp5.service.LineItemService;
import com.bravi.tp5.service.OrderService;
import com.bravi.tp5.service.PaymentService;
import com.bravi.tp5.service.ProductService;
import com.bravi.tp5.service.impl.AccountServiceImpl;
import com.bravi.tp5.service.impl.CustomerServiceImpl;
import com.bravi.tp5.service.impl.LineItemServiceImpl;
import com.bravi.tp5.service.impl.OrderServiceImpl;
import com.bravi.tp5.service.impl.PaymentServiceImpl;
import com.bravi.tp5.service.impl.ProductServiceImpl;
import java.util.Scanner;

public class TP5 {

    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = CustomerServiceImpl.getInstance();
    private static ProductService productService = ProductServiceImpl.getInstance();
    private static LineItemService lineItemService = LineItemServiceImpl.getInstance();
    private static PaymentService paymentService = PaymentServiceImpl.getInstance();
    private static AccountService accountService = AccountServiceImpl.getInstance();
    private static OrderService orderService = OrderServiceImpl.getInstance();

    public static void main(String[] args) {
        int option = 0;
        while (option != 10) {
            option = showGui(option);
        }
    }

    private static int showGui(int option) {
        try {
            printMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> createClient();
                case 2 -> createProduct();
                case 3 -> buyProduct();
                case 4 -> printCart();
                case 5 -> payOrder();
                case 6 -> showCustomersInfo();
                case 7 -> showAccountInfo();
                case 8 -> showOrders();
                case 9 -> showPayments();
                case 10 -> System.out.println("Finalizado");
                default -> System.out.println("Se eligio una opcion invalida");
            }
            return option;
        } catch (NumberFormatException e) {
            System.err.println("Debe escribir un número, por favor intente nuevamente");
        }
        return 0;
    }

    private static void printMenu() {
        System.out.println("1. Crear nuevo cliente");
        System.out.println("2. Crear nuevo producto");
        if (productService.areProductsCreated()) {
            System.out.println("3. Agregar producto al carrito");
            System.out.println("4. Imprimir carrito");
            System.out.println("5. Pagar orden");
        } else {
            System.out.println("3. Agregar producto al carrito - No es "
                    + "posible sin antes crear productos y clientes");
            System.out.println("4. Imprimir carrito - No es posible sin antes"
                    + " crear productos");
            System.out.println("5. Pagar orden - No es posible sin antes "
                    + "crear productos");
        }
        System.out.println("6. Mostrar informacion de clientes creados");
        System.out.println("7. Mostrar cuenta de cliente");
        System.out.println("8. Mostrar ordenes de compra");
        System.out.println("9. Mostrar pagos");
        System.out.println("10. Finalizar");
        System.out.println("Indique numero de opcion deseada");
    }

    private static void createClient() {
        customerService.createCustomer();
    }

    private static void buyProduct() {
        if (productService.areProductsCreated() 
                    && customerService.areCustomersCreated()) {
            productService.buyProducts();
        } else {
            printNotPosibleOption("y clientes");
        }
    }

    private static void createProduct() {
        productService.createProduct();
    }

    private static void payOrder() {
        if (productService.areProductsCreated()) {
            paymentService.payOrder();
        } else {
            printNotPosibleOption(null);
        }
    }

    private static void printNotPosibleOption(String string) {
        if (string != null) {
            System.out.println("No es posible elegir esta opción sin antes "
                    + "crear productos " + string);
        } else {
            System.out.println("No es posible elegir esta opción sin antes "
                    + "crear productos");
        }
    }

    private static void printCart() {
        if (productService.areProductsCreated()) {
            lineItemService.printCart();
        } else {
            printNotPosibleOption(null);
        }
    }

    private static void showCustomersInfo() {
        customerService.showCustomersInfo();
    }

    private static void showAccountInfo() {
        accountService.showAccountInfo();
    }

    private static void showOrders() {
        orderService.printOrders();

    }

    private static void showPayments() {
        paymentService.showPayments();
    }

}
