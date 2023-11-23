package com.example.kompletfysio_backend.dto.dtoemployee;

import com.example.kompletfysio_backend.model.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDTO toDTO(EmployeeEntity employee) {
        return new EmployeeDTO(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getUsername(),
                employee.getPassword(),
                employee.isPartner(),
                employee.getUnavailable(),
                employee.getAppointment(),
                employee.getGeneralAvailability());
    }

    public EmployeeEntity toEntity (EmployeeDTO employeeDTO) {
        return new EmployeeEntity(
                employeeDTO.employeeId(),
                employeeDTO.name(),
                employeeDTO.username(),
                employeeDTO.password(),
                employeeDTO.isPartner(),
                employeeDTO.unavailable(),
                employeeDTO.appointment(),
                employeeDTO.generalAvailability()
        );
    }

}
