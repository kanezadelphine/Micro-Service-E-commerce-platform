package com.kaneza.user_service.service.Impl;

import com.kaneza.user_service.dto.UserDto;
import com.kaneza.user_service.entity.User;
import com.kaneza.user_service.exception.ResourceNotFoundException;
import com.kaneza.user_service.mapper.UserMapper;
import com.kaneza.user_service.repository.UserRepository;
import com.kaneza.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId).
                orElseThrow(()->
                        new ResourceNotFoundException("User not exist with given Id:" + userId));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users =  userRepository.findAll();
        return users.stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->
                new ResourceNotFoundException("user does not exist with given id: " + userId));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());

        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->
                new ResourceNotFoundException("user does not exist with given id:"+ userId));

        userRepository.deleteById(userId);
    }
}
