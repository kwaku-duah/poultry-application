package com.poultry.authservice.service;

import com.poultry.authservice.dto.AuthRequestDto;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<String> login(AuthRequestDto authRequest);
}
