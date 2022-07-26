package com.cassiorsfreitas.restapispring.domain.usecase;

import java.util.Optional;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

public interface UpdateOneGarmentUseCase {
    public GarmentEntity execute(GarmentEntity garmentEntity);
}
