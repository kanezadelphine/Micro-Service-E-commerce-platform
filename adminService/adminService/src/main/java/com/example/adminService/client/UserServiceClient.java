package com.example.adminService.client;



import com.example.adminService.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import org.springframework.http.*;


@Component
public class UserServiceClient {

    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String url;

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserDto> getAllUsers() {

        ResponseEntity<List<UserDto>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<UserDto>>() {
                        });

        return response.getBody();
    }

    public UserDto getUser(Long id) {

        return restTemplate.getForObject(
                url + "/" + id,
                UserDto.class
        );
    }

    public UserDto createUser(UserDto dto) {

        return restTemplate.postForObject(
                url,
                dto,
                UserDto.class
        );
    }

    public UserDto updateUser(Long id, UserDto dto) {

        HttpEntity<UserDto> request = new HttpEntity<>(dto);

        ResponseEntity<UserDto> response =
                restTemplate.exchange(
                        url + "/" + id,
                        HttpMethod.PUT,
                        request,
                        UserDto.class
                );

        return response.getBody();
    }

    public void deleteUser(Long id) {

        restTemplate.delete(url + "/" + id);
    }

}