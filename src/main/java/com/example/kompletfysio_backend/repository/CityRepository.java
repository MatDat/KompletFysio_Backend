package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity findByCityId(int id);
}
