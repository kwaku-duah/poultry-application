package com.poultry.authservice.payload;

public record ErrorResponseHandler(String message, int statusCode) {
}
