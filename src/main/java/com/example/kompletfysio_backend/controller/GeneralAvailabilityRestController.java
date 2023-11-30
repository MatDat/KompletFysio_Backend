package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.availabilityInterval.AvailabilityInterval;
import com.example.kompletfysio_backend.service.GeneralAvailabilityService;
import com.example.kompletfysio_backend.service.UnavailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GeneralAvailabilityRestController {

    @Autowired
    GeneralAvailabilityService generalAvailabilityService;

    @Autowired
    UnavailableService unavailableService;

    @GetMapping("/getEmployeeHoursById/{employeeId}/{date}")
    public ResponseEntity<List<AvailabilityInterval>> getAvailabilityInterval(@PathVariable("employeeId") int employeeId,
                                                                              @PathVariable("date") Date date) {
        List<AvailabilityInterval> availabilityIntervalList = new ArrayList<>();
        System.out.println(employeeId + ", " + date);
        return new ResponseEntity<>(availabilityIntervalList, HttpStatus.OK);
    }


}
