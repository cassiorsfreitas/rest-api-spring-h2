package com.cassiorsfreitas.restapispring.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.GetOneGarmentUseCase;

@Service
public class GetOneGarmentService implements GetOneGarmentUseCase {

    final GarmentRepository garmentRepository;

    public GetOneGarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    public Optional<GarmentEntity> execute(Long id) {
        return garmentRepository.findById(id);
    }
    
}
