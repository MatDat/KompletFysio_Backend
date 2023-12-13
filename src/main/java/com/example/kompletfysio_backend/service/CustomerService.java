package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtocustomer.CustomerConverter;
import com.example.kompletfysio_backend.dto.dtocustomer.CustomerDTO;
import com.example.kompletfysio_backend.dto.dtocustomer.CustomerRequestBody;
import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentDTO;
import com.example.kompletfysio_backend.model.CityEntity;
import com.example.kompletfysio_backend.model.CustomerEntity;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.repository.CityRepository;
import com.example.kompletfysio_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;

    @Autowired
    CityRepository cityRepository;

    public ResponseEntity<CustomerDTO> saveCustomer(CustomerRequestBody customerRB){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCpr(customerRB.cpr());
        customerEntity.setAddress(customerRB.address());
        customerEntity.setUsername(customerRB.username());
        customerEntity.setDateOfBirth(customerRB.dateOfBirth());
        customerEntity.setFirstName(customerRB.firstName());
        customerEntity.setLastName(customerRB.lastName());
        customerEntity.setPassword(customerRB.password());

        Optional<CityEntity> optCity = cityRepository.findByCityAndZipCode(customerRB.city(), customerRB.zipCode());
        if (optCity.isPresent()){
            customerEntity.setCity(optCity.get());
        }else {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setCity(customerRB.city());
            cityEntity.setZipCode(customerRB.zipCode());
            cityRepository.save(cityEntity);
            customerEntity.setCity(cityEntity);
        }

        return new ResponseEntity<>(customerConverter.toDTO(customerRepository.save(customerEntity)), HttpStatus.OK);
    }



    public Optional<CustomerEntity> findById(Long aLong) {
        return customerRepository.findById(aLong.intValue());
    }

    //todo test this
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (CustomerEntity customerEntity: customerEntityList) {
            customerDTOList.add(customerConverter.toDTO(customerEntity));
        }
        return customerDTOList;
    }

}
