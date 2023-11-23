package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.UnavailableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnavailableRepository extends JpaRepository<UnavailableEntity, Integer> {
    UnavailableEntity findByUnavailableId(int id);
}
