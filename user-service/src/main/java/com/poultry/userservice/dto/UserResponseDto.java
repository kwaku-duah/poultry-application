package com.poultry.userservice.dto;

import com.poultry.userservice.entity.Role;

import java.util.Set;

public record UserResponseDto(Long id, String email, Set<Role> roles) {
}
