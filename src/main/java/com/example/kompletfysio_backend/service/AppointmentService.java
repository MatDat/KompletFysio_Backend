package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentConverter;
import com.example.kompletfysio_backend.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    TreatmentConverter treatmentConverter;
}
