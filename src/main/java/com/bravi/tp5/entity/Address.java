package com.bravi.tp5.entity;

public class Address {
    
    private String street;
    private String state;
    private String country;
    private Long houseNumber;
    private Integer floor;

    public Address(String street, String state, String country, 
                   Long houseNumber, Integer floor) {
        this.street = street;
        this.state = state;
        this.country = country;
        this.houseNumber = houseNumber;
        this.floor = floor;
        System.out.println("Constructor Address");
    }
    
    public String getAddress() {
        return String.format("%s %d, floor: %d, %s, %s", street, 
                houseNumber, floor, state, country);
    }

}
