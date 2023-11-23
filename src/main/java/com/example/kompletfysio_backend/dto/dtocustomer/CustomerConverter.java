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
                customer.getCity()
        );
    }

    public CustomerEntity toEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDTO.name());
        customerEntity.setDateOfBirth(customerDTO.dateOfBirth());
        customerEntity.setAddress(customerDTO.address());
        customerEntity.setPersonalIdentificationNumber(customerDTO.personalIdentificationNumber());
        customerEntity.setUsername(customerDTO.username());
        customerEntity.setPassword(customerDTO.password());
        customerEntity.setCity(customerDTO.city());
        return customerEntity;
    }

}
