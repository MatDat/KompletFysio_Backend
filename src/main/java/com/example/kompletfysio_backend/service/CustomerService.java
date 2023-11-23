package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerConverter;
import com.example.kompletfysio_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;


}
