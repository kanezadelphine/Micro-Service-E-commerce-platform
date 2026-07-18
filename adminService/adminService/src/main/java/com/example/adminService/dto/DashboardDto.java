package com.example.adminService.dto;


import lombok.Data;

import java.util.List;

@Data
public class DashboardDto {

    private List<UserDto> users;

    private List<InvatoryDto> inventory;

    private List<ProductDto> products;


}