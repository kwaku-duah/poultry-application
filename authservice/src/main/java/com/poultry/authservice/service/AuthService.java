package com.poultry.authservice.service;

import com.poultry.authservice.dto.AuthRequestDto;
import com.poultry.authservice.dto.AuthResponseDto;
import com.poultry.authservice.dto.AuthUserDto;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<AuthUserDto> login(AuthRequestDto authRequest);
}
