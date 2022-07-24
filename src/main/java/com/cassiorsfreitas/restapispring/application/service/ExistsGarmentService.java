package com.cassiorsfreitas.restapispring.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.ExistsGarmentUseCase;

@Service
public class ExistsGarmentService implements ExistsGarmentUseCase {

    final GarmentRepository garmentRepository;
    
    public ExistsGarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    public boolean execute(String name) {
        List<GarmentEntity> garments = garmentRepository.findAll();
        for (GarmentEntity garment : garments) {
            if (garment.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
    
}
