package com.kaneza.product_service.mapper;

import com.kaneza.product_service.dto.ProductDto;
import com.kaneza.product_service.entity.Product;

public class ProductMapper {

    public static ProductDto mapToDto(Product product) {

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSkuCode()
        );
    }

    public static Product mapToEntity(ProductDto dto) {

        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getSkuCode()
        );
    }
}