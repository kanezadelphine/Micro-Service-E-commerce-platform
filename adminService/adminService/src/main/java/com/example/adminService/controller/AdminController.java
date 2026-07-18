package com.example.adminService.controller;



import com.example.adminService.dto.DashboardDto;
import com.example.adminService.service.AdminService;
import org.springframework.web.bind.annotation.*;


import com.example.adminService.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    // ---------------- Dashboard ----------------

    @GetMapping("/dashboard")
    public DashboardDto dashboard() {
        return adminService.dashboard();
    }

    // ---------------- Users ----------------

    @GetMapping("/users")
    public List<UserDto> users() {
        return adminService.users();
    }

    @GetMapping("/users/{id}")
    public UserDto user(@PathVariable Long id) {
        return adminService.getUser(id);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto dto) {
        return adminService.createUser(dto);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(
            @PathVariable Long id,
            @RequestBody UserDto dto) {

        return adminService.updateUser(id, dto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }

    // ---------------- Inventory ----------------

    @GetMapping("/inventory")
    public List<InvatoryDto> inventory() {
        return adminService.inventory();
    }

    @GetMapping("/inventory/{id}")
    public InvatoryDto inventory(@PathVariable Long id) {
        return adminService.getInventory(id);
    }

    @PostMapping("/inventory")
    public InvatoryDto createInventory(@RequestBody InvatoryDto dto) {
        return adminService.createInventory(dto);
    }

    @PutMapping("/inventory/{id}")
    public InvatoryDto updateInventory(
            @PathVariable Long id,
            @RequestBody InvatoryDto dto) {

        return adminService.updateInventory(id, dto);
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable Long id) {
        adminService.deleteInventory(id);
    }


    // ---------------- Product ----------------


    @GetMapping("/products")
    public List<ProductDto> products() {
        return adminService.products();
    }

    @GetMapping("/products/{id}")
    public ProductDto product(@PathVariable Long id) {
        return adminService.getProduct(id);
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto dto) {
        return adminService.createProduct(dto);
    }

    @PutMapping("/products/{id}")
    public ProductDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto dto) {

        return adminService.updateProduct(id, dto);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        adminService.deleteProduct(id);
    }
}