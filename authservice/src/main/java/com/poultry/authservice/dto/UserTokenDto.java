package com.poultry.authservice.dto;

import com.poultry.authservice.security.enums.Role;

import java.util.Set;

public record UserTokenDto(Long id, String email, Set<Role> roles) {
}
