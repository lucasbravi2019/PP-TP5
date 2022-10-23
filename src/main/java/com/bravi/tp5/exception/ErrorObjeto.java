package com.bravi.tp5.exception;

public class ErrorObjeto extends RuntimeException {

    public ErrorObjeto(String message) {
        super(message);
        System.out.println("Constructor ErrorObjeto");
    }

}
