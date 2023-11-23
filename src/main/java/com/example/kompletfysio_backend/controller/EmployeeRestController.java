package com.example.kompletfysio_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeRestController {

    //Autowire service klassen som ikke er lavet endnu

    /* Snuppet fra kino projekt, har ikke service og DTO klasser endnu
    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO postEmployee(@RequestBody EmployeePasswordDTO employeePasswordDTO){
        return employeeService.save(employeePasswordDTO);
    }
     */
}
