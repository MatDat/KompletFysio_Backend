package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.DurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends JpaRepository<DurationEntity, Integer> {
    DurationEntity findByDurationId(int id);
}
