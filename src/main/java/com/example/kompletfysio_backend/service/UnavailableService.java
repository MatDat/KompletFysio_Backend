package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.repository.UnavailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnavailableService {
    @Autowired
    UnavailableRepository unavailableRepository;
}
