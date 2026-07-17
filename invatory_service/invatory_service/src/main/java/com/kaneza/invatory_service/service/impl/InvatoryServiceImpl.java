package com.kaneza.invatory_service.service.impl;

import com.kaneza.invatory_service.dto.InvatoryDto;
import com.kaneza.invatory_service.entity.Invatory;
import com.kaneza.invatory_service.mapper.InvatoryMapper;
import com.kaneza.invatory_service.repository.InvatoryRepository;
import com.kaneza.invatory_service.service.InvatoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class InvatoryServiceImpl implements InvatoryService {

    private final InvatoryRepository repository;

    @Override
    public InvatoryDto createInvatory(InvatoryDto dto) {

        Invatory invatory = InvatoryMapper.mapToInvatory(dto);

        Invatory savedInvatory = repository.save(invatory);

        return InvatoryMapper.mapToInvatoryDto(savedInvatory);
    }

    @Override
    public InvatoryDto getInvatoryById(Long id) {

        Invatory invatory = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found with id: " + id));

        return InvatoryMapper.mapToInvatoryDto(invatory);
    }

    @Override
    public List<InvatoryDto> getAllInvatory() {

        List<Invatory> invatoryList = repository.findAll();

        return invatoryList.stream()
                .map(InvatoryMapper::mapToInvatoryDto)
                .toList();
    }

    @Override
    public InvatoryDto updateInvatory(Long id, InvatoryDto dto) {

        Invatory invatory = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found with id: " + id));

        invatory.setSkuCode(dto.getSkuCode());
        invatory.setQuantity(dto.getQuantity());
        invatory.setCategory(dto.getCategory());

        Invatory updatedInvatory = repository.save(invatory);

        return InvatoryMapper.mapToInvatoryDto(updatedInvatory);
    }

    @Override
    public void deleteInvatory(Long id) {

        Invatory invatory = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found with id: " + id));

        repository.delete(invatory);
    }

}