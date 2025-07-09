package com.poultry.authservice.dto;


import com.poultry.authservice.security.enums.Role;

import java.util.Set;

public record AuthResponseDto(Long id, String email, String password, Set<Role> roles) {
}