package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeDTO;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.JwtResponseModel;
import com.example.kompletfysio_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> signup(@RequestBody EmployeeDTO request){
//        System.out.println("signup: username:" + request.getUsername() + " password: " + request.getPassword() );
        return employeeService.signup(request);

    }

}
