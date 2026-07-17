package com.kaneza.invatory_service.mapper;

import com.kaneza.invatory_service.dto.InvatoryDto;
import com.kaneza.invatory_service.entity.Invatory;

public class InvatoryMapper {
    public static InvatoryDto mapToInvatoryDto(Invatory invatory){
        return new InvatoryDto(
                invatory.getId(),
                invatory.getSkuCode(),
                invatory.getQuantity(),
                invatory.getCategory()
        );

    }

    public static Invatory mapToInvatory (InvatoryDto invatoryDto){
        return new Invatory(
                invatoryDto.getId(),
                invatoryDto.getSkuCode(),
                invatoryDto.getQuantity(),
                invatoryDto.getCategory()
        );
    }
}
