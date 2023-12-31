package com.example.kompletfysio_backend.model;

import com.example.kompletfysio_backend.model.enumPackage.DayOfWeek;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="general_availability")
public class GeneralAvailabilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="general_availability_id")
    private int generalAvailabilityId;

    @Enumerated(EnumType.STRING)
    @Column(name="day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name="start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name="end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = false)
    private EmployeeEntity employee;


}
