package com.cassiorsfreitas.restapispring.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;
import com.cassiorsfreitas.restapispring.domain.repository.GarmentRepository;
import com.cassiorsfreitas.restapispring.domain.usecase.GetAllGarmentsUseCase;

@Service
public class GetAllGarmentsService implements GetAllGarmentsUseCase {

    @Autowired
    private GarmentRepository garmentRepository;

    public List<GarmentEntity> execute() {
        return garmentRepository.findAll();
    }
}
