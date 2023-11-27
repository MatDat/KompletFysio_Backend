package com.example.kompletfysio_backend.dto.dtoappointment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentDTO(int appointmentID,
                             LocalDateTime startTime,
                             LocalDateTime endtime,
                             String note,
                             int customerId,
                             int employeeId,
                             int treatmentId) {
}
