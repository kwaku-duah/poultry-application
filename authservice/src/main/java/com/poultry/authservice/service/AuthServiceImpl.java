package com.poultry.authservice.service;


import com.poultry.authservice.client.UserServiceClient;
import com.poultry.authservice.dto.AuthRequestDto;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserServiceClient userServiceClient;

    public AuthServiceImpl(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Override
    public Mono<String> login(AuthRequestDto authRequest) {
        return null;

    }
}
