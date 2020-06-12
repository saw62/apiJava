package com.ecommerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionController {

    @ExceptionHandler(value = ProduitIntrouvableException.class)
    public ResponseEntity<Object> exception(ProduitIntrouvableException ex) {
        ApiError apiError = new ApiError(ex, HttpStatus.NOT_FOUND);
       return new ResponseEntity<>(apiError, apiError.getStatus());
    }



}
