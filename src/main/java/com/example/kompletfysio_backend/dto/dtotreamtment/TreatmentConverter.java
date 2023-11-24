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
                treatment.getDuration().getDurationId()
        );
    }

    //We removed toEntity because it doesn't work with durationId, so we'll have to do it in service
}
