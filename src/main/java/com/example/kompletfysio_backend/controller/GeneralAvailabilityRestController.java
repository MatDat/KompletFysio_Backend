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
import java.util.stream.Collectors;

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
        List<AvailabilityInterval> availabilityIntervalList = generalAvailabilityService.getAvailabilityFromEmployeeAndDate(employeeId, localDate);
        System.out.println(employeeId + ", " + date);
        //TODO - if List above is empty (no time is available), the program fails

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

        //makes a list of lists of availability intervals
        List<List<AvailabilityInterval>> availableIntervalListList = new ArrayList<>();
        for (EmployeeDTO employeeDTO : capableEmployeesDto){
            List<AvailabilityInterval> availabilityIntervalList = generalAvailabilityService
                    .getAvailabilityFromEmployeeAndDate(employeeDTO.employeeId(), localDate);
            availableIntervalListList.add(availabilityIntervalList);
        }

        //Adds all timeslot in single arraylist (from multiple employees)
        List<Timeslot> timeslotList = new ArrayList<>();
        for (int i = 0; i < availableIntervalListList.size(); i++) {
            List<Timeslot> timeslots = generalAvailabilityService
                    .getAvailableTimeslots(availableIntervalListList.get(i),
                            duration,
                            availableIntervalListList.get(i).get(0).getEmployee_id());
            timeslotList.addAll(timeslots);
        }

        //removes duplicate timeslots:
        for (int i = 0; i < timeslotList.size(); i++) {
            for (int j = 0; j < timeslotList.size(); j++) {
                if (timeslotList.get(i).getTimeSlot().equals(timeslotList.get(j).getTimeSlot()) &&
                        timeslotList.get(i).getEmployeeID() !=  timeslotList.get(j).getEmployeeID() ){
                    timeslotList.remove(timeslotList.get(j));
                }
            }
        }
        //TODO sort list by time early bird first

        return new ResponseEntity<>(timeslotList, HttpStatus.OK);
    }



}
