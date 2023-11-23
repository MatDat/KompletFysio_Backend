package com.example.kompletfysio_backend.dto.dtotreamtment;

import com.example.kompletfysio_backend.model.TreatmentEntity;
import org.springframework.stereotype.Component;

@Component
public class TreatmentConverter {

    public TreatmentDTO toDTO(TreatmentEntity treatment) {
        return new TreatmentDTO(
                treatment.getTreatmentId(),
                treatment.getTreatmentName(),
                treatment.getPrice(),
                treatment.getDuration()
        );
    }

    public TreatmentEntity toEntity(TreatmentDTO treatmentDTO) {
        return new TreatmentEntity(
                treatmentDTO.treatmentId(),
                treatmentDTO.treatmentName(),
                treatmentDTO.price(),
                treatmentDTO.duration()
        );
    }
}
