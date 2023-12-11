package com.example.kompletfysio_backend.dto.dtocustomer;

import java.time.LocalDate;

public record CustomerRequestBody(int customerId, String firstName, String lastName, LocalDate dateOfBirth, String address,
                          String cpr, String username, String password, String city, String zipCode) {
}