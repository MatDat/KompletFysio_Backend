package com.example.kompletfysio_backend.dto.dtocustomer;

import com.example.kompletfysio_backend.model.AppointmentEntity;
import com.example.kompletfysio_backend.model.CityEntity;

import java.util.Date;
import java.util.Set;

public record CustomerDTO(int customerId, String name, Date dateOfBirth, String address, String personalIdentificationNumber, String username, String password, Set<AppointmentEntity> appointment, CityEntity city) {
}
