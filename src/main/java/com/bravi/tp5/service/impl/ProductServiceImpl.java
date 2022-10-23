package com.bravi.tp5.service.impl;

import com.bravi.tp5.entity.LineItem;
import com.bravi.tp5.entity.Price;
import com.bravi.tp5.entity.Product;
import com.bravi.tp5.repository.ProductRepository;
import com.bravi.tp5.service.LineItemService;
import com.bravi.tp5.service.OrderService;
import com.bravi.tp5.service.ProductService;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

public class ProductServiceImpl implements ProductService {

    public static final int DOLLAR_PRICE = 281;

    private Scanner scanner = new Scanner(System.in);
    private ProductRepository productRepository = ProductRepository.getInstance();
    private LineItemService lineItemService = LineItemServiceImpl.getInstance();
    private OrderService orderService = OrderServiceImpl.getInstance();
    private static ProductServiceImpl instance;

    private ProductServiceImpl() {
        System.out.println("Constructor ProductServiceImpl");
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public void createProduct() {
        System.out.println("Ingrese el nombre del producto");
        String productName = scanner.nextLine();
        Character option = 'Y';
        Product product = new Product(productName,
                () -> String.format("AR-%d", productRepository.getSku()));
        while (option != 'n') {
            System.out.println("Ingrese la cantidad de items del paquete");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese el precio del paquete");
            BigDecimal price = BigDecimal.valueOf(Double.valueOf(scanner.nextLine()));
            Price totalPrice = new Price(price, BigDecimal.valueOf(DOLLAR_PRICE));
            LineItem lineItem = new LineItem(quantity, totalPrice);
            product.addLineItem(lineItem);
            System.out.println("Desea agregar un nuevo paquete? (S/N)");
            option = scanner.nextLine().toLowerCase().charAt(0);
        }
        productRepository.addProduct(product);
    }

    @Override
    public void buyProducts() {
        Set<Product> products = productRepository.getProducts();
        Character option = 'S';
        while (option != 'n') {
            System.out.println("Por favor elija que producto desea agregar");
            products.forEach(product
                    -> System.out.println(product.getSupplier().get() + ": "
                            + product.getName()));
            String sku = scanner.nextLine();
            boolean isProductAvailable = products.stream().anyMatch(product
                    -> product.getSupplier().get().equals(sku));
            if (isProductAvailable) {
                addItemToCart(products, sku);
            } else {
                System.out.println("El producto no existe");
            }
            System.out.println("Desea agregar un nuevo producto? (S/N)");
            option = scanner.nextLine().toLowerCase().charAt(0);
        }
        orderService.createOrder();
    }

    private void addItemToCart(Set<Product> products, String sku) throws NumberFormatException {
        Product productChosen = products.stream()
                .filter(product
                        -> sku.equals(product.getSupplier().get()))
                .findFirst()
                .orElse(null);
        System.out.println("Elija la cantidad de productos que llevara");
        productChosen.getLineItemList().forEach(item ->
                System.out.println(item.getQuantity() + ": $ "
                        + item.getPrice().getPriceInPesos())
        );
        int quantity = Integer.parseInt(scanner.nextLine());
        LineItem lineItem = productChosen.getLineItemList().stream()
                .filter(item -> item.getQuantity() == quantity)
                .findFirst()
                .orElse(null);
        if (lineItem != null) {
            lineItemService.addItemToCart(lineItem);
            System.out.println("Producto agregado: "
                    + productChosen.getSupplier().get() + " "
                    + productChosen.getName() 
                    + "\nPrecio: $ " + lineItem.getPrice().getPriceInPesos()
                    + "\nCantidad: " + lineItem.getQuantity());
        } else {
            System.out.println("El elemento elegido no existe");
        }
    }


}
