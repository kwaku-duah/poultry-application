package com.poultry.userservice.mapper;

import com.poultry.userservice.dto.UserRequestDto;
import com.poultry.userservice.dto.UserResponseDto;
import com.poultry.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    User toEntity(UserRequestDto userRequestDto);

    UserResponseDto toDto(User user);
}
