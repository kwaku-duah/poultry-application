package com.poultry.authservice.service;

import com.poultry.authservice.dto.AuthRequest;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<String> login(AuthRequest authRequest);
}
