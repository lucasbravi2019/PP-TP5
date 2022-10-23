package com.bravi.tp5.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
        System.out.println("Constructor AccountNotFoundException");
    }
    
}
