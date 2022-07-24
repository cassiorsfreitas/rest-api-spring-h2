package com.cassiorsfreitas.restapispring.domain.usecase;

import java.util.List;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

public interface GetAllGarmentsUseCase {
    public List<GarmentEntity> execute();
}
