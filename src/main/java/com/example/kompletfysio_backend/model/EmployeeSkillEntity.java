package com.example.kompletfysio_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_skill")
public class EmployeeSkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeSkillId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = false)
    private EmployeeEntity employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appointment_id", nullable = false)
    private AppointmentEntity appointment;

}
