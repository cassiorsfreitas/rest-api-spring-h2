package com.cassiorsfreitas.restapispring.http.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiorsfreitas.restapispring.application.service.DeleteOneGarmentService;
import com.cassiorsfreitas.restapispring.application.service.GetOneGarmentService;
import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/garment")
public class DeleteOneGarmentController {
    
    final DeleteOneGarmentService deleteOneGarmentService;
    final GetOneGarmentService getOneGarmentService;

    public DeleteOneGarmentController(DeleteOneGarmentService deleteOneGarmentService, GetOneGarmentService getOneGarmentService) {
        this.deleteOneGarmentService = deleteOneGarmentService;
        this.getOneGarmentService = getOneGarmentService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Long id) {
        Optional<GarmentEntity> garmentEntityOptional = getOneGarmentService.execute(id);
        if (!garmentEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Garment not found");
        }
        deleteOneGarmentService.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body("Garment deleted");
    }


}
