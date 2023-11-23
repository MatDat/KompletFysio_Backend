package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    AppointmentEntity findByAppointmentId(int id);
}
