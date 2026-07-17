package com.kaneza.invatory_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InvatoryDto {

    private Long id;
    private String skuCode;
    private Integer quantity;
    private String category;


}
