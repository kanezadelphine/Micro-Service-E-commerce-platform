package com.example.adminService.service;


import com.example.adminService.dto.DashboardDto;
import com.example.adminService.dto.InvatoryDto;
import com.example.adminService.dto.UserDto;

import java.util.List;


public interface AdminService {

    // Dashboard
    DashboardDto dashboard();

    // User
    List<UserDto> users();

    UserDto getUser(Long id);

    UserDto createUser(UserDto dto);

    UserDto updateUser(Long id, UserDto dto);

    void deleteUser(Long id);

    // Inventory
    List<InvatoryDto> inventory();

    InvatoryDto getInventory(Long id);

    InvatoryDto createInventory(InvatoryDto dto);

    InvatoryDto updateInventory(Long id, InvatoryDto dto);

    void deleteInventory(Long id);
}