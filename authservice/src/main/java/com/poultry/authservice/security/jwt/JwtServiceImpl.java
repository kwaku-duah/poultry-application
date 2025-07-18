package com.poultry.authservice.security.jwt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.poultry.authservice.dto.UserTokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
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

        return Jwts.builder()
                .subject(String.valueOf(userTokenDto.id()))
                .claims(claims)
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plus(accessExpiration)))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public String generateRefreshToken(UserTokenDto userTokenDto) {
        return Jwts.builder()
                .subject(String.valueOf(userTokenDto.id()))
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plus(refreshExpiration)))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.get("roles", List.class);
    }

    /*Get claims
    * */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public String extractUserId(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    @Override
    public boolean validateToken(String token) {
        Claims claims = getClaimsFromToken(token); //catch JwtException
        return claims.getExpiration().after(new Date());
    }
}
