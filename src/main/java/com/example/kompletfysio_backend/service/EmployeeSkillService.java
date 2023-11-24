package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.model.EmployeeSkillEntity;
import com.example.kompletfysio_backend.repository.EmployeeRepository;
import com.example.kompletfysio_backend.repository.EmployeeSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;
}
