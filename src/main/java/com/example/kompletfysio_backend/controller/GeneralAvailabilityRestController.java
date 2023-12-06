package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.availabilityInterval.AvailabilityInterval;
import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeDTO;
import com.example.kompletfysio_backend.dto.timeslot.Timeslot;
import com.example.kompletfysio_backend.service.EmployeeService;
import com.example.kompletfysio_backend.service.GeneralAvailabilityService;
import com.example.kompletfysio_backend.service.UnavailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin
@RestController
public class GeneralAvailabilityRestController {

    @Autowired
    GeneralAvailabilityService generalAvailabilityService;

    @Autowired
    UnavailableService unavailableService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployeeHoursById/{employeeId}/{date}/{duration}")
    public ResponseEntity<List<Timeslot>> getAvailabilityInterval(@PathVariable("employeeId") int employeeId,
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
        List<Timeslot> timeslots = generalAvailabilityService.getAvailableTimeslots(availabilityIntervalList, duration, employeeId);
        return new ResponseEntity<>(timeslots, HttpStatus.OK);
    }
    @GetMapping("/getAnyEmployeeHours/{date}/{duration}/{treatmentId}")
    public ResponseEntity<List<Timeslot>> getAvailabilityIntervalOnAnyEmployee(@PathVariable("duration") int duration,
                                                                @PathVariable("date") String date,
                                                                @PathVariable("treatmentId") int treatmentId){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Parse the string into a LocalDate object
        LocalDate localDate = LocalDate.parse(date, formatter);

        //find capable employees based on treatment_id
        List<EmployeeDTO> capableEmployeesDto = employeeService.getEmployeesByTreatmentId(treatmentId);


        List<List<AvailabilityInterval>> availableIntervalListList = new ArrayList<>();

        for (EmployeeDTO employeeDTO : capableEmployeesDto){

            List<AvailabilityInterval> availabilityIntervalList = generalAvailabilityService
                    .getAvailabilityFromEmployeeAndDate(employeeDTO.employeeId(), localDate);
            System.out.println(employeeDTO.employeeId() + ", " + date);

            availableIntervalListList.add(availabilityIntervalList);
        }

        List<Timeslot> timeslotList = new ArrayList<>();
        for (int i = 0; i < availableIntervalListList.size(); i++) {
            List<Timeslot> timeslots = generalAvailabilityService
                    .getAvailableTimeslots(availableIntervalListList.get(i),
                            duration,
                            availableIntervalListList.get(i).get(0).getEmployee_id());

            timeslotList.addAll(timeslots);

        }

        LinkedHashSet<Timeslot> tempRemoveDublicates = (LinkedHashSet<Timeslot>) timeslotList;
        List<Timeslot> timeslotsNoDuplicates = (List<Timeslot>) tempRemoveDublicates;

        //TODO fix line below
        return new ResponseEntity<>(timeslotsNoDuplicates, HttpStatus.OK);
    }



}
