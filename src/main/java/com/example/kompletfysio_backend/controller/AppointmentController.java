package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.dtoappointment.AppointmentDTO;
import com.example.kompletfysio_backend.model.UnavailableEntity;
import com.example.kompletfysio_backend.service.AppointmentService;
import com.example.kompletfysio_backend.service.UnavailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;

    @Autowired
    UnavailableService unavailableService;



    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        ResponseEntity<AppointmentDTO> saveAppointment = appointmentService.save(appointmentDTO);

        if (saveAppointment.getStatusCode() == HttpStatus.OK) {
            unavailableService.setUnavailableFromAppointment(
                    appointmentDTO.startTime(),
                    appointmentDTO.endtime(),
                    appointmentDTO.employeeId());
        } else {
            System.out.println("Error when saving appointment in AppointmentController /appointment");
        }

        return saveAppointment;
    }




}
