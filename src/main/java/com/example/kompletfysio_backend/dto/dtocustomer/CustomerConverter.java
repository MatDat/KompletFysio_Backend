package com.example.kompletfysio_backend.dto.dtocustomer;

import com.example.kompletfysio_backend.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO toDTO(CustomerEntity customer){
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getDateOfBirth(),
                customer.getAddress(),
                customer.getPersonalIdentificationNumber(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getAppointment(),
                customer.getCity()
        );
    }

    public CustomerEntity toEntity(CustomerDTO customerDTO){
        return new CustomerEntity(
                customerDTO.customerId(),
                customerDTO.name(),
                customerDTO.dateOfBirth(),
                customerDTO.address(),
                customerDTO.personalIdentificationNumber(),
                customerDTO.username(),
                customerDTO.password(),
                customerDTO.appointment(),
                customerDTO.city()
        );
    }
}
