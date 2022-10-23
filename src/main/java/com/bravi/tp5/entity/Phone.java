package com.bravi.tp5.entity;

public class Phone {
    
    private Integer countryPrefix;
    private Integer statePrefix;
    private Long phoneNumber;

    public Phone(Integer countryPrefix, Integer statePrefix, Long phoneNumber) {
        this.countryPrefix = countryPrefix;
        this.statePrefix = statePrefix;
        this.phoneNumber = phoneNumber;
        System.out.println("Constructor Phone");
    }
    
    public String getPhoneNumber() {
        return String.format("+%d %d %d", countryPrefix, statePrefix,
                phoneNumber);
    }

}
