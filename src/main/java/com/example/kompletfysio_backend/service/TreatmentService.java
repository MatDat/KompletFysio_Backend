package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentConverter;
import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentDTO;
import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;
    @Autowired
    TreatmentConverter treatmentConverter;

    public List<TreatmentDTO> getAllTreatments(){
        List<TreatmentEntity> treatmentList = treatmentRepository.findAll();
        List<TreatmentDTO> treatmentDTOList = new ArrayList<>();

        for (TreatmentEntity treatmentEntity: treatmentList) {
            treatmentDTOList.add(treatmentConverter.toDTO(treatmentEntity));
        }
        return treatmentDTOList;
    }
}
