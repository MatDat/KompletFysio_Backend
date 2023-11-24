package com.example.kompletfysio_backend.controller;

import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentDTO;
import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TreatmentRestController {

    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/allTreatments")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<TreatmentDTO>> getAllTreatments(){
        List<TreatmentDTO> treatmentDTOList = treatmentService.getAllTreatments();
        return new ResponseEntity<>(treatmentDTOList, HttpStatus.OK);
    }
}
