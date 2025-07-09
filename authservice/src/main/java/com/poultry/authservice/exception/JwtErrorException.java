package com.poultry.authservice.exception;

public class JwtErrorException extends RuntimeException {

    public JwtErrorException(String message) {
        super(message);
    }
}
