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

    @GetMapping("/getEmployeeHoursById/{employeeId}/{date}/{duration}")
    public ResponseEntity<List<String>> getAvailabilityInterval(@PathVariable("employeeId") int employeeId,
                                                                              @PathVariable("date") String date,
                                                                              @PathVariable("duration") int duration)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the string into a LocalDate object
        LocalDate localDate = LocalDate.parse(date, formatter);

        //create the intervals where the employee can work in
        List<AvailabilityInterval> availabilityIntervalList = generalAvailabilityService.getAvailabilityFromEmployeeAndDate(1, localDate);
        System.out.println(employeeId + ", " + date);

        //create the timeslot where the employee can be booked
        List<String> timeslots = generalAvailabilityService.getAvailableTimeslots(availabilityIntervalList, duration);
        return new ResponseEntity<>(timeslots, HttpStatus.OK);
    }


}
