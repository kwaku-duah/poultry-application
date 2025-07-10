package com.poultry.authservice.controller;

import com.poultry.authservice.dto.AuthRequestDto;
import com.poultry.authservice.dto.AuthUserDto;
import com.poultry.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/auth/v1")
public class AuthController {

    public final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping()
    public Mono<ResponseEntity<AuthUserDto>> login(@RequestBody AuthRequestDto authRequestDto) {
        return authService.login(authRequestDto)
                .map(ResponseEntity::ok);
    }

}
