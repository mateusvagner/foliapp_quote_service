package com.foliapp.quoseservice.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String id, String name) {
        super("O cliente informado (" + id + ") (" + name + ") não existe.");
    }
}
