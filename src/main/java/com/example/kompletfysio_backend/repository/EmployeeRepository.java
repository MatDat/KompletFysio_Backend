package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByEmployeeId(int id);

    List<EmployeeEntity> findByUsername(String name);

}
