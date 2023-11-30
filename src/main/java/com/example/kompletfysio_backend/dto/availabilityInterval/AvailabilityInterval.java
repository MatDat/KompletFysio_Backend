package com.example.kompletfysio_backend.dto.availabilityInterval;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class AvailabilityInterval {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
