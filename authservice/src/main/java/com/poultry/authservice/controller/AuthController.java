package com.poultry.authservice.controller;

import com.poultry.authservice.dto.AuthRequestDto;
import com.poultry.authservice.dto.AuthResponseDto;
import com.poultry.authservice.security.jwt.JwtService;
import com.poultry.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class AuthController {

    public final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public Mono<ResponseEntity<AuthResponseDto>> login(@RequestBody AuthRequestDto authRequestDto) {
        return authService.login(authRequestDto)
    }
}
