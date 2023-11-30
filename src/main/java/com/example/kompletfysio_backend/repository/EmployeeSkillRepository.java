package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.EmployeeSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkillEntity, Integer> {
    EmployeeSkillEntity findByEmployeeSkillId(int id);
    List<EmployeeSkillEntity> findByTreatment_TreatmentId(int treatment_id);

}
