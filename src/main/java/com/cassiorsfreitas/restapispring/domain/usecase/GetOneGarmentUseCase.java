package com.cassiorsfreitas.restapispring.domain.usecase;

import java.util.Optional;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

public interface GetOneGarmentUseCase {
    public Optional<GarmentEntity> execute(Long id);
}
