package com.example.kompletfysio_backend.config;

import com.example.kompletfysio_backend.model.*;
import com.example.kompletfysio_backend.model.enumPackage.DayOfWeek;
import com.example.kompletfysio_backend.repository.AppointmentRepository;
import com.example.kompletfysio_backend.repository.EmployeeRepository;
import com.example.kompletfysio_backend.repository.GeneralAvailabilityRepository;
import com.example.kompletfysio_backend.repository.UnavailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeConfig implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UnavailableRepository unavailableRepository;

    @Autowired
    GeneralAvailabilityRepository generalAvailabilityRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {
        initEmployee();
    }


    public void initEmployee() {
        //EMPLOYEE
        EmployeeEntity anneFelskov = createEmployee("Anne", "Felskov", "Anne123", "321ennA", true);
        EmployeeEntity lasseBumbum = createEmployee("Lasse", "Bumbum", "Lasse123", "321essaL", false);

        //UNAVAILABLE
        LocalDateTime startDateTimeUnAv1 = LocalDateTime.of(2023, 11, 27, 12, 0);
        LocalDateTime endDateTimeUnAv1 = LocalDateTime.of(2023, 11, 27, 15, 0);
        createUnavailability(startDateTimeUnAv1, endDateTimeUnAv1, anneFelskov);

        LocalDateTime startDateTimeUnAv3 = LocalDateTime.of(2023, 11, 28, 10, 0);
        LocalDateTime endDateTimeUnAv3 = LocalDateTime.of(2023, 11, 28, 11, 0);
        createUnavailability(startDateTimeUnAv3, endDateTimeUnAv3, anneFelskov);

        LocalDateTime startDateTimeUnAv2 = LocalDateTime.of(2023, 11, 28, 12, 0);
        LocalDateTime endDateTimeUnAv2 = LocalDateTime.of(2023, 11, 28, 15, 0);
        createUnavailability(startDateTimeUnAv2, endDateTimeUnAv2, anneFelskov);

        LocalDateTime startDateTimeUnAv4 = LocalDateTime.of(2023, 11, 28, 8, 0);
        LocalDateTime endDateTimeUnAv4 = LocalDateTime.of(2023, 11, 28, 9, 30);
        createUnavailability(startDateTimeUnAv4, endDateTimeUnAv4, anneFelskov);



        //GENERAL AVAILABILITY
        LocalDateTime startTimeMonday = LocalDateTime.of(2023, 11, 27, 8, 0);
        LocalDateTime endTimeMonday = LocalDateTime.of(2023, 11, 27, 16, 0);
        createGeneralAvailability(DayOfWeek.MONDAY, startTimeMonday, endTimeMonday, anneFelskov);

        LocalDateTime startTimeTuesday = LocalDateTime.of(2023, 11, 28, 8, 0);
        LocalDateTime endTimeTuesday = LocalDateTime.of(2023, 11, 28, 16, 0);
        createGeneralAvailability(DayOfWeek.TUESDAY, startTimeTuesday, endTimeTuesday, anneFelskov);

        LocalDateTime startTimeWednesday = LocalDateTime.of(2023, 11, 29, 8, 0);
        LocalDateTime endTimeWednesday = LocalDateTime.of(2023, 11, 29, 16, 0);
        createGeneralAvailability(DayOfWeek.WEDNESDAY, startTimeWednesday, endTimeWednesday, anneFelskov);

        LocalDateTime startTimeThursday = LocalDateTime.of(2023, 11, 30, 8, 0);
        LocalDateTime endTimeThursday = LocalDateTime.of(2023, 11, 30, 16, 0);
        createGeneralAvailability(DayOfWeek.THURSDAY, startTimeThursday, endTimeThursday, anneFelskov);

        LocalDateTime startTimeFriday = LocalDateTime.of(2023, 12, 1, 8, 0);
        LocalDateTime endTimeFriday = LocalDateTime.of(2023, 12, 1, 16, 0);
        createGeneralAvailability(DayOfWeek.FRIDAY, startTimeFriday, endTimeFriday, anneFelskov);

        LocalDateTime startTimeLørdag = LocalDateTime.of(2023, 12, 1, 10, 0);
        LocalDateTime endTimeLørdag = LocalDateTime.of(2023, 12, 1, 14, 0);
        createGeneralAvailability(DayOfWeek.SATURDAY, startTimeLørdag, endTimeLørdag, anneFelskov);


        createGeneralAvailability(DayOfWeek.MONDAY, startTimeMonday, endTimeMonday, lasseBumbum);


        createGeneralAvailability(DayOfWeek.TUESDAY, startTimeTuesday, endTimeTuesday, lasseBumbum);


        createGeneralAvailability(DayOfWeek.WEDNESDAY, startTimeWednesday, endTimeWednesday, lasseBumbum);


        createGeneralAvailability(DayOfWeek.THURSDAY, startTimeThursday, endTimeThursday, lasseBumbum);


        createGeneralAvailability(DayOfWeek.FRIDAY, startTimeFriday, endTimeFriday, lasseBumbum);


        createGeneralAvailability(DayOfWeek.SATURDAY, startTimeLørdag, endTimeLørdag, lasseBumbum);



        //APPOINTMENT - Mangler customer og treatment
        /*LocalDateTime appointOneStart = LocalDateTime.of(2023, 12, 1, 10, 0);
        LocalDateTime appointOneEnd = LocalDateTime.of(2023, 12, 1, 10, 30);
        createAppointment(appointOneStart, appointOneEnd, "Dagens 'note': Patientens tilstand kan beskrives " +
                "som at være i 'god tilstand' med tilbøjelighed til periodiske 'glædesudbrud'. Anbefalet behandling: " +
                "En daglig dosis af smil og en recept på positivitet!", ??, anneFelskov, ??);*/

        //SKILLS

    }

    private EmployeeEntity createEmployee(
            String firstName,
            String lastName,
            String username,
            String password,
            boolean isPartner) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(firstName);
        employeeEntity.setLastName(lastName);
        employeeEntity.setUsername(username);
        employeeEntity.setPassword(password);
        employeeEntity.setPartner(isPartner);
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }

    private UnavailableEntity createUnavailability(
            LocalDateTime startTime,
            LocalDateTime endTime,
            EmployeeEntity employee) {
        UnavailableEntity unavailableEntity = new UnavailableEntity();
        unavailableEntity.setStartTime(startTime);
        unavailableEntity.setEndTime(endTime);
        unavailableEntity.setEmployee(employee);
        unavailableRepository.save(unavailableEntity);
        return unavailableEntity;
    }

    private GeneralAvailabilityEntity createGeneralAvailability(
            DayOfWeek dayOfWeek,
            LocalDateTime startTime,
            LocalDateTime endTime,
            EmployeeEntity employee) {
        GeneralAvailabilityEntity generalAvailability = new GeneralAvailabilityEntity();
        generalAvailability.setDayOfWeek(dayOfWeek);
        generalAvailability.setStartTime(startTime);
        generalAvailability.setEndTime(endTime);
        generalAvailability.setEmployee(employee);
        generalAvailabilityRepository.save(generalAvailability);
        return generalAvailability;
    }

    private AppointmentEntity createAppointment(
            LocalDateTime startTime,
            LocalDateTime endTime,
            String note,
            CustomerEntity customer,
            EmployeeEntity employee,
            TreatmentEntity treatment) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setStartTime(startTime);
        appointmentEntity.setEndTime(endTime);
        appointmentEntity.setNote(note);
        appointmentEntity.setCustomer(customer);
        appointmentEntity.setEmployee(employee);
        appointmentEntity.setTreatment(treatment);
        appointmentRepository.save(appointmentEntity);
        return appointmentEntity;
    }

    private List<TreatmentEntity> setEmployeeSkill(
            TreatmentEntity treatment,
            EmployeeEntity employee) {
        List<TreatmentEntity> skillList = new ArrayList<>();
        skillList.add(treatment);

        return skillList;
    }
}
