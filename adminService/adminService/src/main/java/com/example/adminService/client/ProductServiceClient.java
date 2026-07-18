package com.example.adminService.client;



import com.example.adminService.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String url;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getAllProducts() {

        ResponseEntity<List<ProductDto>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<ProductDto>>() {}
                );

        return response.getBody();
    }

    public ProductDto getProduct(Long id) {

        return restTemplate.getForObject(
                url + "/" + id,
                ProductDto.class
        );
    }

    public ProductDto createProduct(ProductDto dto) {

        return restTemplate.postForObject(
                url,
                dto,
                ProductDto.class
        );
    }

    public ProductDto updateProduct(Long id, ProductDto dto) {

        HttpEntity<ProductDto> entity = new HttpEntity<>(dto);

        ResponseEntity<ProductDto> response =
                restTemplate.exchange(
                        url + "/" + id,
                        HttpMethod.PUT,
                        entity,
                        ProductDto.class
                );

        return response.getBody();
    }

    public void deleteProduct(Long id) {

        restTemplate.delete(url + "/" + id);
    }

}