package com.poultry.userservice.mapper;

import com.poultry.userservice.dto.UserRequestDto;
import com.poultry.userservice.dto.UserResponseDto;
import com.poultry.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDto userRequestDto);

    @Mapping(target = "password", ignore = true)
    UserResponseDto toDto(User user);
}
