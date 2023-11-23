package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeConverter;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeConverter employeeConverter;

}
