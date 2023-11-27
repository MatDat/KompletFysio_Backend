package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerConverter;
import com.example.kompletfysio_backend.model.CustomerEntity;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;



    public Optional<CustomerEntity> findById(Long aLong) {
        return customerRepository.findById(aLong.intValue());
    }

}
