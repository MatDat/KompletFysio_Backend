package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

}
