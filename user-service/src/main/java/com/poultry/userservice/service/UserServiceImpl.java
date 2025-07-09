package com.poultry.userservice.service;

import com.poultry.userservice.dto.UserLoginRequestDto;
import com.poultry.userservice.dto.UserRequestDto;
import com.poultry.userservice.dto.UserResponseDto;
import com.poultry.userservice.entity.User;
import com.poultry.userservice.mapper.UserMapper;
import com.poultry.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        userRepository.findByEmail(userRequestDto.email())
                .orElseThrow(() -> new ResourceAccessException("User with " + userRequestDto.email() + " not found"));
        User user = userMapper.toEntity(userRequestDto);
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findByEmail(userLoginRequestDto.email())
                .orElseThrow(()-> new ResourceAccessException("User with " + userLoginRequestDto.email() + " email not found"));

        if(!passwordEncoder.matches(userLoginRequestDto.password(),user.getPassword()))
            throw new
    }
}
