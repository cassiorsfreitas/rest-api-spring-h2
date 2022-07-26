package com.cassiorsfreitas.restapispring.http.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiorsfreitas.restapispring.application.service.GetOneGarmentService;
import com.cassiorsfreitas.restapispring.application.service.UpdateOneGarmentService;
import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.http.dto.GarmentDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/garment")
public class UpdateOneGarmentController {
    
    private final UpdateOneGarmentService updateOneGarmentService;
    private final GetOneGarmentService getOneGarmentService;
    
    public UpdateOneGarmentController(UpdateOneGarmentService updateOneGarmentService, GetOneGarmentService getOneGarmentUseCase) {
        this.updateOneGarmentService = updateOneGarmentService;
        this.getOneGarmentService = getOneGarmentUseCase;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> handle(@PathVariable(value = "id") Long id, @RequestBody @Valid GarmentDTO garmentDTO) {
        Optional<GarmentEntity> garmentEntityOptional = getOneGarmentService.execute(id);
        if (!garmentEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Garment not found");
        }

        var garmentEntity = new GarmentEntity();
        BeanUtils.copyProperties(garmentDTO, garmentEntity);
        garmentEntity.setId(garmentEntityOptional.get().getId());
        garmentEntity.setRegistrationDate(garmentEntityOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(updateOneGarmentService.execute(garmentEntity));
    }
}
