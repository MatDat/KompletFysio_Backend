package com.example.kompletfysio_backend.dto.dtoemployee;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerDTO;
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
                employee.isPartner()
        );
    }

    public EmployeeEntity toEntity (EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employeeDTO.employeeId());
        employeeEntity.setName(employeeDTO.name());
        employeeEntity.setUsername(employeeDTO.username());
        employeeEntity.setPassword(employeeDTO.password());
        employeeEntity.setPartner(employeeDTO.isPartner());
        return employeeEntity;
    }
}
