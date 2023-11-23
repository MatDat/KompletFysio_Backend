package com.example.kompletfysio_backend.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    //Autowire customerService?

    /* Snuppet fra kino projektet, men skal bruge DTO og Service klasser
    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.postCustomer(customerDTO), HttpStatus.OK);
    }
     */
}
