package com.ecommerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvableException extends RuntimeException {

    public ResponseEntity<Object> ProduitIntrouvableException(String message) {
        return new ResponseEntity<Object>("produit non trouver", HttpStatus.NOT_FOUND);
    }
}
