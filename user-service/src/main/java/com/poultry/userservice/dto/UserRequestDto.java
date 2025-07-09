package com.poultry.userservice.dto;

import com.poultry.userservice.entity.Role;

import java.util.Set;

public record UserRequestDto(String fullName, String email, String password, Set<Role> roles) {
}
