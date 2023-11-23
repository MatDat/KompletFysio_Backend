package com.example.kompletfysio_backend.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(nullable = false)
    private String name;

    @Column(name="date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Column(name="personal_identification_number", nullable = false)
    private String personalIdentificationNumber;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AppointmentEntity> appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id", nullable = false)
    private CityEntity city;

}

