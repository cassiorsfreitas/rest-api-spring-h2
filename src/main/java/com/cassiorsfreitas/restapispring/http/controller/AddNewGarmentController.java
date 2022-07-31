package com.cassiorsfreitas.restapispring.http.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiorsfreitas.restapispring.application.service.AddNewGarmentService;
import com.cassiorsfreitas.restapispring.application.service.ExistsGarmentService;
import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.http.dto.GarmentDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/garment")
public class AddNewGarmentController {

  final AddNewGarmentService addNewGarmentService;
  final ExistsGarmentService existsGarmentService;

  public AddNewGarmentController(AddNewGarmentService addNewGarmentService, ExistsGarmentService existsGarmentService) {
    this.addNewGarmentService = addNewGarmentService;
    this.existsGarmentService = existsGarmentService;
  }

  @PostMapping
  public ResponseEntity<Object> handle(@RequestBody @Valid GarmentDTO garmentDto) {
    if (existsGarmentService.execute(garmentDto.getName())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Garment already exists");
    }

    var garmentEntity = new GarmentEntity();
    BeanUtils.copyProperties(garmentDto, garmentEntity); // Copy properties from garmentDto to garment
    garmentEntity.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
    return ResponseEntity.status(HttpStatus.CREATED).body(addNewGarmentService.execute(garmentEntity));
  }

}
