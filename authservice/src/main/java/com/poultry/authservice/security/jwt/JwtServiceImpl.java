package com.poultry.authservice.security.jwt;

import com.poultry.authservice.dto.UserTokenDto;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private  final Duration accessExpiration = Duration.ofMinutes(30);
    private final Duration refreshExpiration = Duration.ofDays(7);

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateAccessToken(UserTokenDto userTokenDto) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userTokenDto.roles()
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList()));




        return "";
    }

    @Override
    public String generateRefreshToken(UserTokenDto userTokenDto) {
        return "";
    }

    @Override
    public List<String> extractRoles(String token) {
        return List.of();
    }

    @Override
    public String extractEmail(String token) {
        return "";
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}
