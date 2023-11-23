package com.example.kompletfysio_backend.dto.dtotreamtment;

import com.example.kompletfysio_backend.model.DurationEntity;

public record TreatmentDTO(int treatmentId, String treatmentName, int price, DurationEntity duration) {
}
