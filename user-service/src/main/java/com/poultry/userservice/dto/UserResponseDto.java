package com.poultry.userservice.dto;

import com.poultry.userservice.entity.Role;

public record UserResponseDto(Long id, String email, String password, Role roles) {
}
