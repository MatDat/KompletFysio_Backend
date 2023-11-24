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
                customer.getCity().getCityId()
        );
    }

    //We removed toEntity because it doesn't work with durationId, so we'll have to do it in service

}
