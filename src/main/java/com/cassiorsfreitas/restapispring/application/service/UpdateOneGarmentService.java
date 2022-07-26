package com.cassiorsfreitas.restapispring.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.UpdateOneGarmentUseCase;

@Service
public class UpdateOneGarmentService implements UpdateOneGarmentUseCase {

    final GarmentRepository garmentRepository;

    public UpdateOneGarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    public GarmentEntity execute(GarmentEntity garmentEntity) {
        return garmentRepository.save(garmentEntity);
    }
    
}
