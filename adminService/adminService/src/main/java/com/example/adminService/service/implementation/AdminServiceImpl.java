package com.example.adminService.service.implementation;

import com.example.adminService.client.InventoryServiceClient;
import com.example.adminService.client.ProductServiceClient;
import com.example.adminService.client.UserServiceClient;
import com.example.adminService.dto.DashboardDto;
import com.example.adminService.dto.InvatoryDto;
import com.example.adminService.dto.ProductDto;
import com.example.adminService.dto.UserDto;
import com.example.adminService.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserServiceClient userClient;
    private final InventoryServiceClient inventoryClient;
    private final ProductServiceClient productClient;

    public AdminServiceImpl(UserServiceClient userClient,
                            InventoryServiceClient inventoryClient,
                            ProductServiceClient productClient) {

        this.userClient = userClient;
        this.inventoryClient = inventoryClient;
        this.productClient = productClient;
    }

    @Override
    public UserDto getUser(Long id) {
        return userClient.getUser(id);
    }

    @Override
    public UserDto createUser(UserDto dto) {
        return userClient.createUser(dto);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        return userClient.updateUser(id, dto);
    }

    @Override
    public void deleteUser(Long id) {
        userClient.deleteUser(id);
    }

    @Override
    public List<InvatoryDto> inventory() {
        return inventoryClient.getAllInventory();
    }

    @Override
    public InvatoryDto getInventory(Long id) {
        return inventoryClient.getInventory(id);
    }

    @Override
    public InvatoryDto createInventory(InvatoryDto dto) {
        return inventoryClient.createInventory(dto);
    }

    @Override
    public InvatoryDto updateInventory(Long id, InvatoryDto dto) {
        return inventoryClient.updateInventory(id, dto);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryClient.deleteInventory(id);
    }
    @Override
    public List<UserDto> users() {
        return userClient.getAllUsers();
    }

    //DashBoard
    @Override
    public DashboardDto dashboard() {

        DashboardDto dto = new DashboardDto();

        dto.setUsers(userClient.getAllUsers());
        dto.setInventory(inventoryClient.getAllInventory());
        dto.setProducts(productClient.getAllProducts());

        return dto;
    }

    // products

    @Override
    public List<ProductDto> products() {
        return productClient.getAllProducts();
    }

    @Override
    public ProductDto getProduct(Long id) {
        return productClient.getProduct(id);
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        return productClient.createProduct(dto);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        return productClient.updateProduct(id, dto);
    }

    @Override
    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
    }
}