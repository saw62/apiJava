package com.ecommerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ApiError {

    private HttpStatus status;
    private Date date;
    private String message;

    public ApiError(Exception ex, HttpStatus status) {
        this.status = status;
        this.date = new Date();
        this.message = ex.getMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
