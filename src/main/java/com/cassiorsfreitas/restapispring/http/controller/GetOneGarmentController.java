package com.cassiorsfreitas.restapispring.http.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiorsfreitas.restapispring.application.service.GetOneGarmentService;
import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/garment")
public class GetOneGarmentController {
    
    final GetOneGarmentService getOneGarmentService;

    public GetOneGarmentController(GetOneGarmentService getOneGarmentService) {
        this.getOneGarmentService = getOneGarmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Long id) {
        Optional<GarmentEntity> garmentEntityOptional = getOneGarmentService.execute(id);
        if (!garmentEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Garment not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(garmentEntityOptional.get());
    }


}
