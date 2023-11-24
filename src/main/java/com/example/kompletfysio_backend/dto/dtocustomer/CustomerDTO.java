package com.example.kompletfysio_backend.dto.dtocustomer;

import com.example.kompletfysio_backend.model.CityEntity;

import java.time.LocalDate;

public record CustomerDTO(int customerId, String name, Date dateOfBirth, String address,
                          String personalIdentificationNumber, String username, String password, int cityId) {
}
