package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerDTO;
import com.example.kompletfysio_backend.dto.dtocustomer.CustomerRequestBody;
import com.example.kompletfysio_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;


    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerRequestBody customerRB){
        return customerService.saveCustomer(customerRB);
    }

    @PostMapping("/logInCustomer")
    public ResponseEntity<CustomerDTO> logInCustomer(@RequestBody CustomerRequestBody customerRequestBody){
        return customerService.logIn(customerRequestBody);
    }
    //THIS ENDPOINT ONLY WORKS WITH TOKEN
    //GET TOKEN BY /login with employee credentials
    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers () {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerDTOList, HttpStatus.OK);
    }


    /*
    @GetMapping("/allTreatments")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TreatmentDTO>> getAllTreatments(){
        List<TreatmentDTO> treatmentDTOList = treatmentService.getAllTreatments();
        return new ResponseEntity<>(treatmentDTOList, HttpStatus.OK);
    }
     */


}
