package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.model.GeneralAvailabilityEntity;
import com.example.kompletfysio_backend.model.enumPackage.DayOfWeek;
import com.example.kompletfysio_backend.repository.GeneralAvailabilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class GeneralAvailabilityService {
    @Autowired
    GeneralAvailabilityRepository generalAvailabilityRepository;


    public void getAvailabilityFromEmployeeAndDate(int employeeId, LocalDate date) {

//        GeneralAvailabilityEntity gAEntity = generalAvailabilityRepository
//                .findByDayOfWeekAndEmployeeEmployeeId(convertToDayOfWeek(date), employeeId);
        GeneralAvailabilityEntity gAEntity = generalAvailabilityRepository
                .findByDayOfWeekAndEmployeeEmployeeId(convertToDayOfWeek(date), employeeId);
        System.out.println(gAEntity.toString());

    }

    private DayOfWeek convertToDayOfWeek(LocalDate date) {

        return switch (date.getDayOfWeek()) {
            case MONDAY -> DayOfWeek.MONDAY;
            case TUESDAY -> DayOfWeek.TUESDAY;
            case WEDNESDAY -> DayOfWeek.WEDNESDAY;
            case THURSDAY -> DayOfWeek.THURSDAY;
            case FRIDAY -> DayOfWeek.FRIDAY;
            case SATURDAY -> DayOfWeek.SATURDAY;
            case SUNDAY -> DayOfWeek.SUNDAY;
        };
    }


}
