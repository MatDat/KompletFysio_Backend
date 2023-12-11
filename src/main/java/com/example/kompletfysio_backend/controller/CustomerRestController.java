package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerDTO;
import com.example.kompletfysio_backend.dto.dtocustomer.CustomerRequestBody;
import com.example.kompletfysio_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerRequestBody customerRB){
        return customerService.saveCustomer(customerRB);
    }


}
