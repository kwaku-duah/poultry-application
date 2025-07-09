package com.poultry.authservice.exception;


import com.poultry.authservice.payload.ErrorResponseHandler;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponseHandler>> handleGenericException(Exception ex) {
        ErrorResponseHandler response = new ErrorResponseHandler("An unexpected error occurred, please contact support", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response));
    }

    @ExceptionHandler(JwtException.class)
    public  Mono<ResponseEntity<ErrorResponseHandler>> handleJwtException(JwtException ex) {
        ErrorResponseHandler response = new ErrorResponseHandler("Invalid or expired JWT token", HttpStatus.UNAUTHORIZED.value());
        return Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response));
    }
    

}
