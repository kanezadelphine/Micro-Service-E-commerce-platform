package com.kaneza.invatory_service.service;


import com.kaneza.invatory_service.dto.InvatoryDto;

import java.util.List;

public interface InvatoryService {
   InvatoryDto createInvatory(InvatoryDto invatoryDto);
   InvatoryDto getInvatoryById(Long invatoryId);

   List<InvatoryDto> getAllInvatory();

   InvatoryDto updateInvatory(Long invatoryId, InvatoryDto invatoryDto);

   void deleteInvatory(Long invatoryId);
}
