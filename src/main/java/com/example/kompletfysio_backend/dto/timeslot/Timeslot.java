package com.example.kompletfysio_backend.dto.timeslot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Timeslot {
    private int employeeID;
    private String timeslot;


    public String getTimeSlot() {
        return timeslot;
    }

}
