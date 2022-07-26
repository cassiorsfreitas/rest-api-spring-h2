package com.cassiorsfreitas.restapispring.application.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.DeleteOneGarmentUseCase;

@Service
public class DeleteOneGarmentService implements DeleteOneGarmentUseCase {

    final GarmentRepository garmentRepository;

    public DeleteOneGarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    @Transactional
    public void execute(Long id) {
        garmentRepository.deleteById(id);
    }
    
}
