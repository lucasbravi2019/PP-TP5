package com.bravi.tp5.enumeration;

public enum OrderStatus {
    NEW("Nueva"),
    HOLD("Pendiente"),
    SHIPPED("Enviada"),
    DELIVERED("Entregada"),
    CLOSED("Cerrada");
    
    private String status;
    
    OrderStatus(String status) {
        this.status = status;
        System.out.println("Constructor OrderStatus");
    }

    public String getStatus() {
        return status;
    }
    
}
