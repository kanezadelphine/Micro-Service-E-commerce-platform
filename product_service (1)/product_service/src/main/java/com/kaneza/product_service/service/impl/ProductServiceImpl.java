package com.kaneza.product_service.service.impl;



import com.kaneza.product_service.dto.ProductDto;
import com.kaneza.product_service.entity.Product;
import com.kaneza.product_service.exception.ResourceNotFoundException;
import com.kaneza.product_service.mapper.ProductMapper;
import com.kaneza.product_service.repository.ProductRepository;
import com.kaneza.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductDto createProduct(ProductDto dto) {

        Product product = ProductMapper.mapToEntity(dto);

        Product saved = repository.save(product);

        return ProductMapper.mapToDto(saved);
    }

    @Override
    public ProductDto getProductById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        return ProductMapper.mapToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return repository.findAll()
                .stream()
                .map(ProductMapper::mapToDto)
                .toList();
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setSkuCode(dto.getSkuCode());

        Product updated = repository.save(product);

        return ProductMapper.mapToDto(updated);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id " + id));

        repository.delete(product);
    }
}