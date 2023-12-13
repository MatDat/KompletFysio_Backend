package com.example.kompletfysio_backend.dto.dtocustomer;

import com.example.kompletfysio_backend.model.CityEntity;

import java.time.LocalDate;

public record CustomerDTO(int customerId, String firstName,String lastName, LocalDate dateOfBirth, String address,
                          String cpr, String username, String password, int cityId) {

}
