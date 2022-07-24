package com.cassiorsfreitas.restapispring.domain.usecase;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

public interface AddNewGarmentUseCase {
    public GarmentEntity execute(GarmentEntity garment);
}
