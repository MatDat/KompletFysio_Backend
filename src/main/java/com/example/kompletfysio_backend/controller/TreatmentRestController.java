package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TreatmentRestController {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/allTreatments")
    public TreatmentEntity[] getAllTreatments(){
        return treatmentService.getAllTreatments();
    }
}
