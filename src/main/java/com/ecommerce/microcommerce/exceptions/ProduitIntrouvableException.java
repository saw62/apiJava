package com.ecommerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProduitIntrouvableException extends RuntimeException {

    public ProduitIntrouvableException(String message) {
        super(message);
    }
}
