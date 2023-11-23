package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.repository.GeneralAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralAvailabilityService {
    @Autowired
    GeneralAvailabilityRepository generalAvailabilityRepository;
}
