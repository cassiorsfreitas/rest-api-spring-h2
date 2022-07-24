package com.cassiorsfreitas.restapispring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassiorsfreitas.restapispring.domain.entity.GarmentEntity;

@Repository
public interface GarmentRepository extends JpaRepository<GarmentEntity, Long> {
}
   
