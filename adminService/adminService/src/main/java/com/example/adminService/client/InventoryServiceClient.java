package com.example.adminService.client;



import com.example.adminService.dto.InvatoryDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.springframework.http.*;
import org.springframework.stereotype.Component;

    @Component
    public class InventoryServiceClient {

        private final RestTemplate restTemplate;

        @Value("${inventory.service.url}")
        private String url;

        public InventoryServiceClient(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public List<InvatoryDto> getAllInventory() {

            ResponseEntity<List<InvatoryDto>> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<InvatoryDto>>() {
                            });

            return response.getBody();
        }

        public InvatoryDto getInventory(Long id) {

            return restTemplate.getForObject(
                    url + "/" + id,
                    InvatoryDto.class
            );
        }

        public InvatoryDto createInventory(InvatoryDto dto) {

            return restTemplate.postForObject(
                    url,
                    dto,
                    InvatoryDto.class
            );
        }

        public InvatoryDto updateInventory(Long id, InvatoryDto dto) {

            HttpEntity<InvatoryDto> request = new HttpEntity<>(dto);

            ResponseEntity<InvatoryDto> response =
                    restTemplate.exchange(
                            url + "/" + id,
                            HttpMethod.PUT,
                            request,
                            InvatoryDto.class
                    );

            return response.getBody();
        }

        public void deleteInventory(Long id) {

            restTemplate.delete(url + "/" + id);
        }

    }