package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.GeneralAvailabilityEntity;
import com.example.kompletfysio_backend.model.enumPackage.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAvailabilityRepository extends JpaRepository<GeneralAvailabilityEntity, Integer> {
    GeneralAvailabilityEntity findByGeneralAvailabilityId(int id);


    GeneralAvailabilityEntity findByDayOfWeekAndEmployeeEmployeeId(DayOfWeek dayOfWeek, int id);

}
