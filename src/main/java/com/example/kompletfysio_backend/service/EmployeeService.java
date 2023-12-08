package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.config.SecurityConfiguration;
import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeConverter;
import com.example.kompletfysio_backend.dto.dtoemployee.EmployeeDTO;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.EmployeeSkillEntity;
import com.example.kompletfysio_backend.model.JwtResponseModel;
import com.example.kompletfysio_backend.repository.EmployeeRepository;
import com.example.kompletfysio_backend.repository.EmployeeSkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeSkillRepository employeeSkillRepository;
    private EmployeeConverter employeeConverter;

    public ResponseEntity<JwtResponseModel> signup(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeId(employeeDTO.employeeId());
        employee.setUsername(employeeDTO.username());
        employee.setPassword(employeeDTO.password());
        employee.setPartner(employeeDTO.isPartner());
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());

        if (findByName(employee.getUsername()).size() == 0) {
            if (save(employee) != null) {
                return ResponseEntity.ok(new JwtResponseModel("created user: " + employee.getUsername() + " pw: " + employee.getPassword()));
            } else {
                return ResponseEntity.ok(new JwtResponseModel("error creating user: " + employee.getUsername()));
            }
        } else {
            return ResponseEntity.ok(new JwtResponseModel("error: user exists: " + employee.getUsername()));
        }
    }

    public ResponseEntity<JwtResponseModel> addNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeId(employeeDTO.employeeId());
        employee.setUsername(employeeDTO.username());
        employee.setPassword(employeeDTO.password());
        employee.setPartner(employeeDTO.isPartner());
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());

        if (findByName(employee.getUsername()).size() == 0) {
            if (save(employee) != null) {
                return ResponseEntity.ok(new JwtResponseModel("created user: " + employee.getUsername() + " pw: " + employee.getPassword()));
            } else {
                return ResponseEntity.ok(new JwtResponseModel("error creating user: " + employee.getUsername()));
            }
        } else {
            return ResponseEntity.ok(new JwtResponseModel("error: user exists: " + employee.getUsername()));
        }
    }

    public List<EmployeeDTO> getEmployeesByTreatmentId(int treatment_id) {
        //Get a list of employee skills, based on given treatmentId
        List<EmployeeSkillEntity> employeeSkills = employeeSkillRepository.findByTreatment_TreatmentId(treatment_id);

        //only add the capable employees to the list
        List<EmployeeEntity> employeeList = new ArrayList<>();
        for (int i = 0; i < employeeSkills.size(); i++) {
            employeeList.add(employeeSkills.get(i).getEmployee());
        }

        //change employee to DTO instead of Entity
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (EmployeeEntity employee : employeeList) {
            employeeDTOList.add(employeeConverter.toDTO(employee));
        }

        return employeeDTOList;
    }

    @Override
    public Set<EmployeeEntity> findAll() {
        Set<EmployeeEntity> set = new HashSet<>();
        employeeRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
        employeeEntity.setPassword(pw.encode(employeeEntity.getPassword()));
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void delete(EmployeeEntity object) {
        employeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<EmployeeEntity> findById(Long aLong) {
        return employeeRepository.findById(aLong.intValue());
    }

    @Override
    public List<EmployeeEntity> findByName(String name) {
        System.out.println("Employeeservice called findByName with argument: " + name);
        return employeeRepository.findByUsername(name);
    }
}
