package com.poultry.userservice.service;

import com.poultry.userservice.dto.UserLoginRequestDto;
import com.poultry.userservice.dto.UserRequestDto;
import com.poultry.userservice.dto.UserResponseDto;
import com.poultry.userservice.entity.User;
import com.poultry.userservice.mapper.UserMapper;
import com.poultry.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByEmail(userRequestDto.email())
                .orElseThrow(() -> new )
    }

    @Override
    public UserResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {
        return null;
    }
}
