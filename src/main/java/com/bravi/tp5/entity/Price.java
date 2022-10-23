package com.bravi.tp5.entity;

import java.math.BigDecimal;

public class Price {
    
    private BigDecimal priceInDollars;
    private BigDecimal priceInPesos;
    private BigDecimal pricePerDollar;
    
    public Price(BigDecimal priceInPesos, BigDecimal pricePerDollar) {
        this.priceInPesos = priceInPesos;
        this.pricePerDollar = pricePerDollar;
        this.priceInDollars = priceInPesos.multiply(pricePerDollar);
        System.out.println("Constructor Price");
    }

    public BigDecimal getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(BigDecimal priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public BigDecimal getPriceInPesos() {
        return priceInPesos;
    }

    public void setPriceInPesos(BigDecimal priceInPesos) {
        this.priceInPesos = priceInPesos;
    }

    public BigDecimal getPricePerDollar() {
        return pricePerDollar;
    }

    public void setPricePerDollar(BigDecimal pricePerDollar) {
        this.pricePerDollar = pricePerDollar;
    }
    
}
