package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.dtoappointment.AppointmentConverter;
import com.example.kompletfysio_backend.dto.dtoappointment.AppointmentDTO;
import com.example.kompletfysio_backend.dto.dtotreamtment.TreatmentConverter;
import com.example.kompletfysio_backend.model.AppointmentEntity;
import com.example.kompletfysio_backend.model.CustomerEntity;
import com.example.kompletfysio_backend.model.EmployeeEntity;
import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.repository.AppointmentRepository;
import com.example.kompletfysio_backend.repository.EmployeeRepository;
import com.example.kompletfysio_backend.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

   @Autowired
   AppointmentRepository appointmentRepository;
   @Autowired
   AppointmentConverter appointmentConverter;

   @Autowired
   EmployeeService employeeService;

   @Autowired
   CustomerService customerService;
   @Autowired
   TreatmentService treatmentService;

   @Autowired
    EmployeeRepository employeeRepository;



    public ResponseEntity<AppointmentDTO> save(AppointmentDTO appointmentDTO){
        System.out.println("TEST1");
        AppointmentEntity appointment = new AppointmentEntity();
//        appointment.setAppointmentId(appointmentDTO.appointmentID());
        appointment.setStartTime(appointmentDTO.startTime());
        appointment.setEndTime(appointmentDTO.endtime());
        appointment.setNote(appointmentDTO.note());
        System.out.println(appointment.getNote());

        Optional<EmployeeEntity> optionalEmployee = employeeService.findById((long) appointmentDTO.employeeId());
        if (optionalEmployee.isEmpty()){
            return (null);//TODO SPØRG JARL
        }
        appointment.setEmployee(optionalEmployee.get());
        System.out.println(appointment.getEmployee().toString());

        Optional<CustomerEntity> optionalCustomer = customerService.findById((long) appointmentDTO.customerId());
        if (optionalCustomer.isEmpty()){
            return (null); //TODO SPØRG JARL
        }
        appointment.setCustomer(optionalCustomer.get());

        Optional<TreatmentEntity> optionalTreatment = treatmentService.findById((long) appointmentDTO.treatmentId());
        if (optionalTreatment.isEmpty()){
            return (null); //TODO SPØRG JARL
        }
        appointment.setTreatment(optionalTreatment.get());
        AppointmentDTO app = appointmentConverter.toDTO(appointmentRepository.save(appointment));
        return ResponseEntity.ok(app);

    }

}
