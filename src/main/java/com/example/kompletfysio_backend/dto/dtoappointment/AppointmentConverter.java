package com.example.kompletfysio_backend.dto.dtoappointment;

import com.example.kompletfysio_backend.model.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter {
    public AppointmentDTO toDTO(AppointmentEntity appointment){
        return new AppointmentDTO(appointment.getAppointmentId(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                appointment.getNote(),
                appointment.getCustomer().getCustomerId(),
                appointment.getEmployee().getEmployeeId(),
                appointment.getTreatment().getTreatmentId());
    }
}
