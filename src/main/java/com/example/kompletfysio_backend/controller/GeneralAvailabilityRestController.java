package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.availabilityInterval.AvailabilityInterval;
import com.example.kompletfysio_backend.service.GeneralAvailabilityService;
import com.example.kompletfysio_backend.service.UnavailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class GeneralAvailabilityRestController {

    @Autowired
    GeneralAvailabilityService generalAvailabilityService;

    @Autowired
    UnavailableService unavailableService;

    @GetMapping("/getEmployeeHoursById/{employeeId}/{date}")
    public ResponseEntity<List<AvailabilityInterval>> getAvailabilityInterval(@PathVariable("employeeId") int employeeId,
                                                                              @PathVariable("date") String date) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the string into a LocalDate object
        LocalDate localDate = LocalDate.parse(date, formatter);


        List<AvailabilityInterval> availabilityIntervalList = generalAvailabilityService.getAvailabilityFromEmployeeAndDate(1, localDate);
        System.out.println(employeeId + ", " + date);
        return new ResponseEntity<>(availabilityIntervalList, HttpStatus.OK);
    }


}
