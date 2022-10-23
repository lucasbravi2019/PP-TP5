package com.bravi.tp5.entity;

import com.bravi.tp5.enumeration.OrderStatus;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Order {

    private String number;
    private LocalDate ordered;
    private LocalDate shipped;
    private Address shipTo;
    private OrderStatus status;
    private BigDecimal total;
    private Account account;

    public Order(String number, LocalDate ordered, LocalDate shipped,
            Address shipTo, OrderStatus status, BigDecimal total) {
        this.number = number;
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.status = status;
        this.total = total;
        System.out.println("Constructor Order");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getOrdered() {
        return ordered;
    }

    public void setOrdered(LocalDate ordered) {
        this.ordered = ordered;
    }

    public LocalDate getShipped() {
        return shipped;
    }

    public void setShipped(LocalDate shipped) {
        this.shipped = shipped;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void printOrder() {
        System.out.println("********************");
        System.out.println("Cliente: " + account.getCustomer().getEmail());
        System.out.println("Numero de orden: " + number);
        System.out.println("Fecha de creacion de orden: " + getDate(ordered));
        if (shipped != null) {
            System.out.println("Fecha de envio: " + getDate(shipped));
        }
        System.out.println("Direccion a enviar: " + shipTo.getAddress());
        System.out.println("Estado: " + status.getStatus());
        System.out.println("Total: " + total.setScale(2, RoundingMode.CEILING));
        System.out.println("********************");
    }

    private String getDate(LocalDate date) {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }

}
