package com.poultry.authservice.security.jwt;

import com.poultry.authservice.dto.UserTokenDto;

import java.util.List;


public interface JwtService {
    String generateAccessToken(UserTokenDto userTokenDto);
    String generateRefreshToken(UserTokenDto userTokenDto);
    List<String> extractRoles(String token);
    String extractUserId(String token);
    boolean validateToken(String token);
}
