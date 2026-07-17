package com.kaneza.user_service.service;

import com.kaneza.user_service.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long UserId, UserDto updatedUser);
    void deleteUser(Long userId);
}
