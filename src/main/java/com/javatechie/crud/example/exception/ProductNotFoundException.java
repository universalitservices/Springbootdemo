package com.javatechie.crud.example.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String product_not_found) {
    }
}
