package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.TreatmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentEntity, Integer> {
    TreatmentEntity findByTreatmentId(int id);
}
