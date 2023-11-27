package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.model.EmployeeEntity;

import java.util.List;

public interface IEmployeeService extends ICrudService<EmployeeEntity,Long>{
    List<EmployeeEntity> findByName(String name);
}