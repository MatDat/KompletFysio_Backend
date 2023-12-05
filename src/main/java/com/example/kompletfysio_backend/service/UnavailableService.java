package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.UnavailableEntity;
import com.example.kompletfysio_backend.repository.UnavailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UnavailableService {
    @Autowired
    UnavailableRepository unavailableRepository;

    @Autowired
    EmployeeService employeeService;


    public ResponseEntity<UnavailableEntity> setUnavailableFromAppointment(LocalDateTime start, LocalDateTime end, int employeeId){

        Optional<EmployeeEntity> optEmployee = employeeService.findById((long) employeeId);

        if (optEmployee.isEmpty()){
            System.out.println("Somthing went wrong saving unavailability");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        EmployeeEntity employee = optEmployee.get();

        UnavailableEntity unavailableEntity = new UnavailableEntity(0,start,end, employee);

        return new ResponseEntity<>(unavailableRepository.save(unavailableEntity), HttpStatus.OK);

    }

}
