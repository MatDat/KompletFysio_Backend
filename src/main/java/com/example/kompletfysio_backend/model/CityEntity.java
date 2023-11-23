package com.example.kompletfysio_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private int cityId;

    @Column(name="zip_code", nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy="city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CustomerEntity> customer;
}
