package com.codigo.spring_g17.exception;

import org.springframework.http.HttpStatus;

public class BadRequestArticuloException extends RuntimeException {
    public BadRequestArticuloException(String message) {
        super(message);
    }
}
