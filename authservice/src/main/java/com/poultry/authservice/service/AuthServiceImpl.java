package com.poultry.authservice.service;


import com.poultry.authservice.client.UserServiceClient;
import com.poultry.authservice.dto.AuthRequestDto;
import com.poultry.authservice.dto.AuthResponseDto;
import com.poultry.authservice.dto.AuthUserDto;
import com.poultry.authservice.dto.UserTokenDto;
import com.poultry.authservice.security.jwt.JwtService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserServiceClient userServiceClient;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserServiceClient userServiceClient, JwtService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.userServiceClient = userServiceClient;
        this.jwtService=jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Mono<AuthUserDto> login(AuthRequestDto authRequest) {

        return userServiceClient.getUserByEmail(authRequest.email())
                .filter(user -> passwordEncoder.matches(authRequest.password(), user.password() ))
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User " + authRequest.email() + "not found")))
                .map(user -> {
                    UserTokenDto userToken = new UserTokenDto(user.id(), user.email(), user.roles());
                    String token = jwtService.generateAccessToken(userToken);
                    return new AuthUserDto(token);
                });
    }
}
