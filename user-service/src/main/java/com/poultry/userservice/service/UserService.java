package com.poultry.userservice.service;

import com.poultry.userservice.dto.UserRequestDto;
import com.poultry.userservice.dto.UserResponseDto;

public interface UserService {
    UserResponseDto login(UserRequestDto userRequestDto);

}
