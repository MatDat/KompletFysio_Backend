package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.repository.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DurationService {

    @Autowired
    DurationRepository durationRepository;
}
