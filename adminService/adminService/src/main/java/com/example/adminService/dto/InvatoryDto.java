package com.example.adminService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvatoryDto {

    private Long id;

    private String skuCode;

    private Integer quantity;

    private String category;

}