package com.cassiorsfreitas.restapispring.http.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassiorsfreitas.restapispring.application.service.GetAllGarmentsService;
import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/garments")
public class GetAllGarmentsController {

    final GetAllGarmentsService getAllGarmentsService;

    public GetAllGarmentsController(GetAllGarmentsService getAllGarmentsService) {
        this.getAllGarmentsService = getAllGarmentsService;
    }

    @GetMapping
    public ResponseEntity<List<GarmentEntity>> handle() {
        return ResponseEntity.status(HttpStatus.OK).body(getAllGarmentsService.execute());
    }
     
}
