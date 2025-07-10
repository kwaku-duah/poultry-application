package com.poultry.userservice.service;

import com.poultry.userservice.dto.UserResponseDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponseDto> findByEmail(String email);
}
