package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.EmployeeSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkillEntity, Integer> {
    EmployeeSkillEntity findByEmployeeSkillId(int id);

}
