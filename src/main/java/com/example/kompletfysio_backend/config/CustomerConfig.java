package com.example.kompletfysio_backend.config;

import com.example.kompletfysio_backend.model.AppointmentEntity;
import com.example.kompletfysio_backend.model.CityEntity;
import com.example.kompletfysio_backend.model.CustomerEntity;
import com.example.kompletfysio_backend.repository.CityRepository;
import com.example.kompletfysio_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
@Component
public class CustomerConfig implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        //INIT Cities
        CityEntity valby = initCityEntity("2500", "Valby");
        CityEntity holbaek = initCityEntity("4300", "Holbæk");
        CityEntity vig = initCityEntity("5460", "Vig");

        CustomerEntity customer1 = initCustomerEntity("John", "Doe",
                LocalDate.of(1990, 5, 15),
                "123 Main St", "DDmmYY1111", "john.doe@example.com", "password123", valby);

        CustomerEntity customer2 = initCustomerEntity("Jane", "Smith",
                LocalDate.of(1985, 8, 22),
                "456 Oak St", "DDmmYY2222", "jane.smith@example.com", "password456", holbaek);

        CustomerEntity customer3 = initCustomerEntity("Bob", "Johnson",
                LocalDate.of(1978, 3, 10),
                "789 Pine St", "DDmmYY3333", "bob.johnson@example.com", "password789", vig);
    }

    private CityEntity initCityEntity(String zipcode, String cityName) {
        CityEntity city = new CityEntity();
        city.setZipCode(zipcode);
        city.setCity(cityName);
        cityRepository.save(city);
        return city;
    }

    private CustomerEntity initCustomerEntity(String firstName, String lastName, LocalDate dateOfBirth,
                                              String address, String cpr, String username, String password, CityEntity city) {
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDateOfBirth(dateOfBirth);
        customer.setAddress(address);
        customer.setCpr(cpr);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setCity(city);
        customerRepository.save(customer);
        return customer;
    }
}
