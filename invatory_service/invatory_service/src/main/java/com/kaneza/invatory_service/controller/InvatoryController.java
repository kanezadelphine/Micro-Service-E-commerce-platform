package com.kaneza.invatory_service.controller;


import com.kaneza.invatory_service.dto.InvatoryDto;
import com.kaneza.invatory_service.service.InvatoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invatory")

public class InvatoryController {


    private final InvatoryService invatoryService;

    @PostMapping
    public ResponseEntity<InvatoryDto> createInvatory(@RequestBody InvatoryDto invatoryDto){
        return new ResponseEntity<>(
                invatoryService.createInvatory(invatoryDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvatoryDto> getInvatoryById(@PathVariable Long id){
        return ResponseEntity.ok(invatoryService.getInvatoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvatoryDto>> getAllInvatory(){
        return ResponseEntity.ok(invatoryService.getAllInvatory());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvatoryDto> updateInvatory(
            @PathVariable Long id,
            @RequestBody InvatoryDto dto){

        return ResponseEntity.ok(invatoryService.updateInvatory(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvatory(@PathVariable Long id){

        invatoryService.deleteInvatory(id);

        return ResponseEntity.ok("Inventory deleted successfully");
    }
}