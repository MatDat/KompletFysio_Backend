package com.example.kompletfysio_backend.dto.dtocustomer;

import com.example.kompletfysio_backend.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO toDTO(CustomerEntity customer){
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDateOfBirth(),
                customer.getAddress(),
                customer.getCpr(),
                customer.getUsername(),
                customer.getPassword(),
                customer.getCity()
        );
    }

    public CustomerEntity toEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerDTO.firstName());
        customerEntity.setLastName(customerDTO.lastName());
        customerEntity.setDateOfBirth(customerDTO.dateOfBirth());
        customerEntity.setAddress(customerDTO.address());
        customerEntity.setCpr(customerDTO.cpr());
        customerEntity.setUsername(customerDTO.username());
        customerEntity.setPassword(customerDTO.password());
        customerEntity.setCity(customerDTO.city());
        return customerEntity;
    }

}
