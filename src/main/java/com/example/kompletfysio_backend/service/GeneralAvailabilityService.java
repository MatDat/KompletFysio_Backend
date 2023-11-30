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


    public void getAvailabilityFromEmployeeAndDate(int employeeId, LocalDate date){

        GeneralAvailabilityEntity gAEntity = generalAvailabilityRepository
                .findByDayOfWeekAndEmployeeEmployeeId(DayOfWeek.SUNDAY, employeeId);

        System.out.println(gAEntity.toString());

    }



}
