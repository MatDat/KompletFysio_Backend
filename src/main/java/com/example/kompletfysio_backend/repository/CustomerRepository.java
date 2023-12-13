package com.example.kompletfysio_backend.repository;

import com.example.kompletfysio_backend.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByCustomerId(int id);


    Optional<CustomerEntity> findByUsernameAndPassword(String user, String pass);
}
