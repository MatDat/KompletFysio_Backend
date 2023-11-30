package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.UnavailableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UnavailableRepository extends JpaRepository<UnavailableEntity, Integer> {
    UnavailableEntity findByUnavailableId(int id);

//    List<UnavailableEntity> findByEmployee_EmployeeIdAnd

    Optional<List<UnavailableEntity>> findByEmployee_EmployeeIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            int employeeId, LocalDateTime endOfDay, LocalDateTime startOfDay);
}
