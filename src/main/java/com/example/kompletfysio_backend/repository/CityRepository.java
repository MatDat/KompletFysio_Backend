package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity findByCityId(int id);

    Optional<CityEntity> findByCityAndZipCode(String city, String zip);

}
