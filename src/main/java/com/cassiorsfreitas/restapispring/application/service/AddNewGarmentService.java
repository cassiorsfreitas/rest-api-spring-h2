package com.cassiorsfreitas.restapispring.application.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.AddNewGarmentUseCase;

@Service
public class AddNewGarmentService implements AddNewGarmentUseCase {

    final GarmentRepository garmentRepository;
    
    public AddNewGarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    @Transactional // Ensure that the transaction is committed or rolled back
    public GarmentEntity execute(GarmentEntity garment) {
        return garmentRepository.save(garment);
    }
}
