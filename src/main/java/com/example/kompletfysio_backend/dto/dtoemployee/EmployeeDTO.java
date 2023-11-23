package com.example.kompletfysio_backend.dto.dtoemployee;

import com.example.kompletfysio_backend.model.AppointmentEntity;
import com.example.kompletfysio_backend.model.GeneralAvailabilityEntity;
import com.example.kompletfysio_backend.model.UnavailableEntity;

import java.util.Set;

public record EmployeeDTO(int employeeId, String name, String username, String password, boolean isPartner) {
}
