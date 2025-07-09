package com.poultry.authservice.security.jwt;

import com.poultry.authservice.dto.UserTokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generateAccessToken(UserTokenDto userTokenDto) {
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
